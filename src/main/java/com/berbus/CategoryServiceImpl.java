package com.berbus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public void createCategory(Category category) {
        this.categoryRepo.save(category);
    }

    @Override
    public Category getCategory(Long id) {
        return null;
    }

    @Override
    public List<Category> getAllCategory() {
        return this.categoryRepo.findAll();
    }

    @Override
    public Category updateCategory(Category category) {
        return null;
    }

    @Override
    public void deleteCategory(int id) {
        this.categoryRepo.deleteById((long) id);
    }

    @Override
    public Category getCategoryByName(String name) {
        return null;
    }
}
