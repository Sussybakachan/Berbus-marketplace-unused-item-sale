package com.berbus;

public interface CategoryService {

    void createCategory(Category category);

    Category getCategory(Long id);

    Category updateCategory(Category category);

    void deleteCategory(Long id);

    Category getCategoryByName(String name);
}
