package com.ecommerce.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.ecommerce.backend.dto.ProductRequestDTO;
import com.ecommerce.backend.dto.ProductResponseDTO;
import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.exception.ProductNotFoundException;
import com.ecommerce.backend.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
@Override
public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
    // Implementation for creating a

   Product product = new Product();
    product.setName(productRequestDTO.getName());
    product.setDescription(productRequestDTO.getDescription());
    product.setImageUrl(productRequestDTO.getImageUrl());
    product.setPrice(productRequestDTO.getPrice());
    product.setStockQuantity(productRequestDTO.getStockQuantity());
    product=productRepository.save(product);
    
    return ProductResponseDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .imageUrl(product.getImageUrl())
            .price(product.getPrice())
            .stockQuantity(product.getStockQuantity())
            .createdAt(product.getCreatedAt())
            .updatedAt(product.getUpdatedAt())
            .build();
}
    @Override
    public ProductResponseDTO getProductById(Long id) {
    Product product = productRepository.findById(id).orElseThrow(() ->
     new ProductNotFoundException("Prodcut not exist with Id " + id));
     
     return ProductResponseDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .imageUrl(product.getImageUrl())
            .price(product.getPrice())
            .stockQuantity(product.getStockQuantity())
            .createdAt(product.getCreatedAt())
            .updatedAt(product.getUpdatedAt())
            .build();// Implementation for retrieving a product by ID
    
    }
@Override
public void deleteProduct(Long id) {

    Product product = productRepository.findById(id)
            .orElseThrow(() -> new ProductNotFoundException ("Product not found with id: " + id));
    productRepository.delete(product);
}

@Override
public ProductResponseDTO updateProduct(Long id,ProductRequestDTO productRequestDTO){
Product product = productRepository.findById(id)
        .orElseThrow(() -> new ProductNotFoundException ("Product not found with id: " + id));

    product.setName(productRequestDTO.getName());
    product.setDescription(productRequestDTO.getDescription());
    product.setImageUrl(productRequestDTO.getImageUrl());
    product.setPrice(productRequestDTO.getPrice());
    product.setStockQuantity(productRequestDTO.getStockQuantity());

    Product updatedProduct = productRepository.save(product);

    return ProductResponseDTO.builder()
            .id(updatedProduct.getId())
            .name(updatedProduct.getName())
            .description(updatedProduct.getDescription())
            .imageUrl(updatedProduct.getImageUrl())
            .price(updatedProduct.getPrice())
            .stockQuantity(updatedProduct.getStockQuantity())
            .createdAt(updatedProduct.getCreatedAt())
            .updatedAt(updatedProduct.getUpdatedAt())
            .build();

}
@Override
public Page<ProductResponseDTO> getAllProducts(int page, int size, String sortBy) {
Pageable pageable =PageRequest.of(page,size,Sort.by(sortBy));

    Page<Product> products = productRepository.findAll(pageable);

    return products.map(product -> ProductResponseDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .imageUrl(product.getImageUrl())
                    .price(product.getPrice())
                    .stockQuantity(product.getStockQuantity())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt())
                    .build());
            
}
@Override
public List<ProductResponseDTO> searchProducts ( String keyword) {

    List<Product> products = productRepository.findByNameContainingIgnoreCase(keyword);

    return products.stream()
    .map(product -> ProductResponseDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .imageUrl(product.getImageUrl())
                    .price(product.getPrice())
                    .stockQuantity(product.getStockQuantity())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt())
                    .build())
                    .toList();
                            }

                            @Override
public List<ProductResponseDTO> filterProducts(BigDecimal minPrice, BigDecimal maxPrice) {

    List<Product> products =
            productRepository.findByPriceBetween(minPrice, maxPrice);

    return products.stream().map(product -> ProductResponseDTO.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .imageUrl(product.getImageUrl())
                    .stockQuantity(product.getStockQuantity())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt())
                    .build())
            .toList();
}

}