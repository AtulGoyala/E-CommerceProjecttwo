package com.example.EcommerceProject.Controller;

import com.example.EcommerceProject.Model.Message;
import com.example.EcommerceProject.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contact") // Base path for all the contact-related routes
public class ContactController {

    @Autowired
    private ContactService contactService;

    // Display the contact form with an empty Message object
    @GetMapping("/contactUs")
    public String contactPage(Model model) {
        model.addAttribute("message", new Message()); // Create an empty Message object to bind the form
        return "ContactUs"; // Make sure this template exists
    }

    // Handle the form submission (send the message)
    @PostMapping("/send/message")
    public String sendMessage(@ModelAttribute Message message, Model model) {
        // Save the message to the database using ContactService
        contactService.createMessage(message);

        // Add a confirmation message to be displayed to the user
        model.addAttribute("confirmation", "Your message has been successfully sent!");

        // Redirect back to the contact form page
        return "redirect:/contact/contactUs"; // Ensure this matches the path in the controller
    }
}

