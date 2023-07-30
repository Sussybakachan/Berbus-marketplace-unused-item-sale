package com.berbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;
    
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/all")
    public String getProductsPage(Model m, Authentication user) {
        m.addAttribute("ProductList", this.productServiceImpl.getAllProducts());
        m.addAttribute("AccountName", user.getName());
        return "edit";
    }

    @GetMapping("/createProductForm")
    public String getCreateProductForm(Model m, Authentication user) {
        m.addAttribute("categoryList",this.categoryServiceImpl.getAllCategory());
        m.addAttribute("AccountName", user.getName());
        m.addAttribute("product", new Product());
        return "upload";
    }

    @GetMapping("/showProduct/{id}")
    public String getProductPage(@PathVariable("id") long id, Model m, Authentication user) {
        m.addAttribute("product", this.productServiceImpl.getProduct(id));
        m.addAttribute("AccountName", user.getName());
        return "details";
    }

    @GetMapping("/category/{categoryName}")
    public String getProductsByCategoryName(@PathVariable String categoryName, Model model) {
        System.out.println(categoryName);
        System.out.println(productServiceImpl.getProductsByCategoryName(categoryName));
        List<Product> products =  productServiceImpl.getProductsByCategoryName(categoryName);
        model.addAttribute("kundenBuchungen", products);
        //TODO add the right html page to be returned
        return "index";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product) {
        System.out.println("TESTSETSETSETSETSET");
        productServiceImpl.createProduct(product);
        return "redirect:/products/all";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteCustomer(@PathVariable long id){
        this.productServiceImpl.deleteProduct(id);
        return "redirect:/products/all";
    }
}
