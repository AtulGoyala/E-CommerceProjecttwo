package com.example.EcommerceProject.Controller;

import com.example.EcommerceProject.Model.Message; // ✅ Correct import
import com.example.EcommerceProject.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/send/message")
    public String sendMessage(@ModelAttribute Message message, Model model) {
        contactService.createMessage(message);
        model.addAttribute("confirmation", "Your message has been successfully sent!!");
        return "ContactUs";
    }
}
