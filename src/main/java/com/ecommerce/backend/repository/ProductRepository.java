package com.ecommerce.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.ecommerce.backend.entity.Product;
import java.math.BigDecimal;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String Keyword);
List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

}
