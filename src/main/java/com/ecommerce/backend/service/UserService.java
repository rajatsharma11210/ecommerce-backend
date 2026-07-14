package com.ecommerce.backend.service;
import com.ecommerce.backend.dto.LoginRequestDTO;
import com.ecommerce.backend.dto.LoginResponseDTO;
import com.ecommerce.backend.dto.RegisterRequestDTO;
import com.ecommerce.backend.dto.RegisterResponseDTO;


public interface UserService {

    RegisterResponseDTO register(RegisterRequestDTO request);
    
LoginResponseDTO login(LoginRequestDTO request);
}
