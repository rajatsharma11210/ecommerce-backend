package com.ecommerce.backend.dto;
import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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



public class ProductRequestDTO {
@NotBlank(message="name is required")
private String name;

@NotBlank(message="description is required")
@Size(max=1000,message="description should not exceed 1000 characters")
private String description;

@NotBlank(message ="image URL is required")
private String imageUrl;

@NotNull(message="price is required")
@Positive(message ="price not be 0 or negative")
private BigDecimal price;

@NotNull(message="Stock quantity is required")
@Min(value=0,message="stock quantity should not be negative")   
private Integer stockQuantity;


}
