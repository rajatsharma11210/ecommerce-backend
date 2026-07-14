package com.ecommerce.backend.service;
import java.util.List;
import com.ecommerce.backend.dto.ProductRequestDTO;
import com.ecommerce.backend.dto.ProductResponseDTO;
import org.springframework.data.domain.Page;
import java.math.BigDecimal;

public interface ProductService {
    
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    ProductResponseDTO getProductById(Long id);
    ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO);

    void deleteProduct(Long id);

    Page<ProductResponseDTO> getAllProducts(int page, int size, String sortBy);

    List<ProductResponseDTO> searchProducts(String keyword);
    List<ProductResponseDTO>filterProducts(BigDecimal minPrice, BigDecimal maxPrice);


}
