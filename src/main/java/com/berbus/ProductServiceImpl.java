package com.berbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

}
