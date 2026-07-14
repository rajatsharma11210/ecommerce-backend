package com.ecommerce.backend.service;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.dto.LoginRequestDTO;
import com.ecommerce.backend.dto.LoginResponseDTO;
import com.ecommerce.backend.dto.RegisterRequestDTO;
import com.ecommerce.backend.dto.RegisterResponseDTO;
import com.ecommerce.backend.entity.User;
import com.ecommerce.backend.exception.EmailAlreadyExistException;
import com.ecommerce.backend.exception.UserNotFoundException;
import com.ecommerce.backend.repository.UserRepository;
import com.ecommerce.backend.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    public RegisterResponseDTO register(RegisterRequestDTO request) {
        // Check if the email already exists
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new EmailAlreadyExistException("Email already exists: " + request.getEmail());
        }

        // Create a new User entity and save it to the database
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // Hash the password before saving
        user.setRole("USER"); // Set a default role for the user

user.setPassword(passwordEncoder.encode(request.getPassword()));
user.setRole("ROLE_USER");


        User savedUser = userRepository.save(user);

        // Return a response DTO
        return RegisterResponseDTO.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .build();
    }
    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {
        // Find the user by email
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + request.getEmail()));

        // Check if the password matches
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new UserNotFoundException ("Invalid password");
        }
String token = jwtService.generateToken(user.getEmail()); // Generate a JWT token for the user
        // Return a response DTO
        return LoginResponseDTO.builder()
                .message("Login successful")
                .token(token)
                .build();
    }   



}
