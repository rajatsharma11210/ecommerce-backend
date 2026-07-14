package com.ecommerce.backend.entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="name is required")

    private String name;

    @NotNull(message="price is required")
    @Positive(message ="price not be 0 or negative")
    private BigDecimal price;

    @NotBlank(message="description is required")
    @Size(max=1000,message="description should not exceed 1000 characters")
    private String description;

    @NotNull(message="Stock quantity is required")
    @Min(value=0,message="stock quantity should not be negative")
    private Integer stockQuantity;

    @NotBlank(message ="image URL is required")
    @Pattern(regexp="^(http?|ftp)://.*$",message="Please enter valid url")
    private String imageUrl;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
