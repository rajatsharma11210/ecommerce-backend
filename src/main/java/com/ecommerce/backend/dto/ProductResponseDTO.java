package com.ecommerce.backend.dto;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

public class ProductResponseDTO {

private String name;
private String description;
private String imageUrl;    
private BigDecimal price;
private Integer stockQuantity;
private LocalDateTime createdAt;
private LocalDateTime updatedAt;
private Long id;


}
