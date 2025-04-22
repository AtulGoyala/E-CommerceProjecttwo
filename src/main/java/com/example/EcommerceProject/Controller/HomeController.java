package com.example.EcommerceProject.Controller;

import com.example.EcommerceProject.Model.Admin;
import com.example.EcommerceProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping({"/", "/home"})
    public String homePage() {
        return "HomePage";
    }

    @GetMapping("/Products")
    public String productPage(Model model) {
        model.addAttribute("productList", productService.getAllProduct());
        return "ProductPage";
    }

    @GetMapping("/ContactUs")
    public String contactPage() {
        return "ContactPage";
    }

    @GetMapping("/About")
    public String aboutUs() {
        return "AboutUS";
    }

    @GetMapping("/Login")
    public String login(Model model) {
        model.addAttribute("admin", new Admin());
        return "Login";
    }
}
