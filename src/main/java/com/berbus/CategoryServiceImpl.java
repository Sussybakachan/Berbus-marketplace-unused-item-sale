package com.berbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Override
    public void createCategory(Category category) {

    }

    @Override
    public Category getCategory(Long id) {
        return null;
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategory(Long id) {

    }

    @Override
    public Category getCategoryByName(String name) {
        return null;
    }
}
