package com.berbus.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.berbus.Model.Product;
import com.berbus.Repository.ProductRepo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void createProduct(Product product) {
        this.productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepo.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        Optional<Product> optional = productRepo.findById(id);
        Product product = null;
        if(optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException("Für die id:" + id +" ist kein Produkt bekannt.");
        }
        return product;
    }


    @Override
    public void deleteProduct(Long id) {
        this.productRepo.deleteById(id);
    }

    @Override
    public List<Product> getProductsByCategoryName(String categoryName) {
        return productRepo.findByCategoryCategoryName(categoryName);
    }

    @Override
    public void uploadFile(MultipartFile imageFile, String fileName, String uploadDirectory) throws IOException {
        Path uploadPath = Paths.get(uploadDirectory);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
        try (InputStream inputStream = imageFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath);
        } catch (IOException ioe) {
            throw new IOException("Bild konnte nicht gespeichert werden. ");
        }
    }

}
