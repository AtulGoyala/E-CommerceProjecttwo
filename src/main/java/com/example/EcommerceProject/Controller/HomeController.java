package com.example.EcommerceProject.Controller;

import com.example.EcommerceProject.Model.Admin;
import com.example.EcommerceProject.Model.Message;
import com.example.EcommerceProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home") // ✅ Added to prevent URL mapping conflicts
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping({"", "/", "/home"})
    public String homePage() {
        return "HomePage";
    }

    @GetMapping("/products")
    public String productPage(Model model) {
        model.addAttribute("productList", productService.getAllProduct());
        return "Products";
    }

    @GetMapping("/contactUs")
    public String contactPage(Model model) {
        model.addAttribute("message", new Message());
        return "ContactUs";
    }

    @PostMapping("/send/message") // ✅ Now maps to /home/send/message
    public String sendMessage(@ModelAttribute Message message, Model model) {
        model.addAttribute("confirmation", "Your message has been sent successfully!");
        return "ContactUs";
    }

    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "AboutUs";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("admin", new Admin());
        return "LoginPage";
    }
}
