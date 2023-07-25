package com.berbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CategoryController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/")
    public String showHomepage(Model m){
        m.addAttribute("ProductList", this.productServiceImpl.getAllProducts());
        m.addAttribute("categoryList",this.categoryServiceImpl.getAllCategory());
        return "shop";
    }
}
