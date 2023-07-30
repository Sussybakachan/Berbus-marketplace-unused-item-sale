package com.berbus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.berbus.Model.Product;

import java.util.List;


@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategoryCategoryName(String categoryName);

}



