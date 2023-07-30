package com.berbus;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductService {

    void createProduct(Product product);

    Product getProduct(Long id);

    void deleteProduct(Long id);

    List<Product> getProductsByCategoryName(String categoryName);

    List<Product> getAllProducts();
}
