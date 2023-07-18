package com.berbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public Product getProduct(Long id) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    @Override
    public List<Product> getProductsByCategoryName(String categoryName) {
        return productRepo.findByCategoryCategoryName(categoryName);
    }

}
