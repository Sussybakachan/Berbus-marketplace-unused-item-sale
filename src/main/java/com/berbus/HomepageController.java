package com.berbus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class HomepageController {
    
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping("/")
    public String showHomepage(Model m, Authentication user){
        m.addAttribute("ProductList", this.productServiceImpl.getAllProducts());
        m.addAttribute("categoryList",this.categoryServiceImpl.getAllCategory());
        m.addAttribute("AccountName", user.getName());
        return "shop";
    }

    @GetMapping("/logout") 
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);
        }  
         return "redirect:/";  
     }  
}
