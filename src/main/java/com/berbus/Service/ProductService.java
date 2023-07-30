package com.berbus.Service;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.berbus.Model.Product;

import java.io.IOException;
import java.util.List;

@Component
public interface ProductService {

    void createProduct(Product product);

    Product getProduct(Long id);

    void deleteProduct(Long id);

    List<Product> getProductsByCategoryName(String categoryName);

    List<Product> getAllProducts();
    
    void uploadFile(MultipartFile imageFile, String fileName, String uploadDirectory) throws IOException;
}
