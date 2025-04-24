package com.example.EcommerceProject.Controller;

import com.example.EcommerceProject.Model.Admin;
import com.example.EcommerceProject.Model.Message; // ✅ Correct import
import com.example.EcommerceProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    // Show the Home page
    @GetMapping({"/", "/home"})
    public String homePage() {
        return "HomePage"; // Render the HomePage template
    }

    // Show the Products page
    @GetMapping("/products")
    public String productPage(Model model) {
        model.addAttribute("productList", productService.getAllProduct());
        return "Products"; // Render the Products template
    }

    // Show the Contact Us page with the form
    @GetMapping("/contactUs")
    public String contactPage(Model model) {
        model.addAttribute("message", new Message()); // Bind an empty Message object to the form
        return "ContactUs"; // Render the ContactUs template
    }

    @PostMapping("/send/message")
    public String sendMessage(@ModelAttribute Message message, Model model) {

        model.addAttribute("confirmation", "Your message has been sent successfully!");


        return "ContactUs";
    }

    // Show the About Us page
    @GetMapping("/aboutUs")
    public String aboutUs() {
        return "AboutUs"; // Render the AboutUs template
    }

    // Show the Login page
    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("admin", new Admin()); // Add an empty Admin object to the model
        return "LoginPage"; // Render the LoginPage template
    }
}
