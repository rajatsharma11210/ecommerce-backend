package com.ecommerce.backend.controller;
import com.ecommerce.backend.util.ApiResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import com.ecommerce.backend.dto.ProductRequestDTO;
import com.ecommerce.backend.dto.ProductResponseDTO;
import com.ecommerce.backend.service.ProductService;

import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
private final ProductService productService;

@PreAuthorize("hasRole('ADMIN')")
@PostMapping
public String createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
 productService.createProduct(productRequestDTO);
    return "Product created successfully.";
}

@GetMapping
public ApiResponse< Page<ProductResponseDTO>> getAllProducts(
@RequestParam(defaultValue ="0")int page,
@RequestParam(defaultValue ="5")int size,
@RequestParam(defaultValue ="id")String sortBy) {
    return ApiResponse.<Page<ProductResponseDTO>>builder()
    .success(true)
    .message("Product Fetched Successfully")
        .data(productService.getAllProducts(page,size,sortBy))
        .build();
    
}

@GetMapping("/{id}")
public ApiResponse<ProductResponseDTO> getProductById(@PathVariable Long id) {
     return ApiResponse.<ProductResponseDTO>builder()
    .success(true)
    .message("Product Fetched Successfully")
        .data(productService.getProductById(id))
        .build();

}
@PreAuthorize("hasRole('ADMIN')")
@PutMapping("/{id}")
public String  updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO) {
     productService.updateProduct(id, productRequestDTO);
return"Prodcut with ID " + id +  "has been updated successfully";
}
@PreAuthorize("hasRole('ADMIN')")
@DeleteMapping("/{id}")
public String deleteProduct(@PathVariable Long id) {
    productService.deleteProduct(id);
    return "Product with ID " + id + " has been deleted successfully.";
}

@GetMapping("/search")
public ApiResponse<List<ProductResponseDTO>> searchProducts(@RequestParam String keyword){

return ApiResponse.<List<ProductResponseDTO>>builder()
.success(true)
.message("Prodcut Found")
.data(
productService.searchProducts(keyword)
)
.build();
}
@GetMapping("/filter")
public ApiResponse<List <ProductResponseDTO>> filterProducts(
@RequestParam BigDecimal minPrice,
@RequestParam BigDecimal maxPrice){
return ApiResponse.<List<ProductResponseDTO>>builder()
.success(true)
.message("Fetch Succesfully")
.data(
productService.filterProducts (minPrice, maxPrice)
)
.build();
}


}