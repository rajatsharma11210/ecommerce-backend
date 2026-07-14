package com.ecommerce.backend.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Data

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable =false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;    

    @Column(nullable = false)
    private String role;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

@PrePersist
public void prePersist(){
createdAt=LocalDateTime.now();
updatedAt = LocalDateTime.now();

}
@PreUpdate
public void preUpdate(){
    updatedAt = LocalDateTime.now();

  
}

}
