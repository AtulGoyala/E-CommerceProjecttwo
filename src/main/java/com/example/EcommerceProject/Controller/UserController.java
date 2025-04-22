package com.example.EcommerceProject.Controller;
import com.example.EcommerceProject.Model.Admin;
import com.example.EcommerceProject.Model.User;
import com.example.EcommerceProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/add/user")
    public String addUserForm() {
        return "AddUser";
    }

    @PostMapping("/add/user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "Login";
    }
    @GetMapping("/update/user/{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        model.addAttribute("admin", userService.getUserById(id));
        return "UpdateUser";
    }
    @PostMapping("/update/user")
    public String updateUser(User user) {
        userService.createUser(user);
        return "/admin/home";
    }
    @DeleteMapping("/delete/user")
    public String deleteUser(@PathVariable Long id){
  userService.deleteUser(id);
        return "/admin/home";
        }

    }

