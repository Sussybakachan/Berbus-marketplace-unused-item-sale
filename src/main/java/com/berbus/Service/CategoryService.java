package com.berbus.Service;

import java.util.List;

import com.berbus.Model.Category;

public interface CategoryService {

    void createCategory(Category category);

    Category getCategory(Long id);
    
    List<Category> getAllCategory();

    Category updateCategory(Category category);

    void deleteCategory(int id);

    Category getCategoryByName(String name);
}
