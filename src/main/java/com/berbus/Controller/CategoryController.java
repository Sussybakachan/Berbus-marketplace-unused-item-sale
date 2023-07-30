package com.berbus.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.berbus.Model.Category;
import com.berbus.Service.CategoryServiceImpl;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @PostMapping("/saveCategory")
    public String saveCategory(@RequestBody Category c) {
        this.categoryServiceImpl.createCategory(c);
        return "redirect:/";
    }

    @GetMapping("/deleteCategory/{id}")
    public String deleteCustomer(@PathVariable("id") int id){
        this.categoryServiceImpl.deleteCategory(id);
        return "redirect:/";
    }
}
