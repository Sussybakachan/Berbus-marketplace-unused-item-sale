package com.berbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/category/{categoryName}")
    public String getProductsByCategoryName(@PathVariable String categoryName, Model model) {
        System.out.println(categoryName);
        System.out.println(productServiceImpl.getProductsByCategoryName(categoryName));
        List<Product> products =  productServiceImpl.getProductsByCategoryName(categoryName);
        model.addAttribute("kundenBuchungen", products);
        //TODO add the right html page to be returned
        return "index";
    }

    @GetMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("kunde") Product product) {
       productServiceImpl.createProduct(product);
       //TODO add the right html page to be returned
        return "redirect:/";
    }

    @GetMapping("/delteProduct/{id}")
    public String deleteCustomer(@PathVariable long id){
        this.productServiceImpl.deleteProduct(id);
        //TODO add the right html page to be returned
        return "redirect:/";
    }


}
