package com.berbus;

import java.util.List;

public interface CategoryService {

    void createCategory(Category category);

    Category getCategory(Long id);
    
    List<Category> getAllCategory();

    Category updateCategory(Category category);

    void deleteCategory(int id);

    Category getCategoryByName(String name);
}
