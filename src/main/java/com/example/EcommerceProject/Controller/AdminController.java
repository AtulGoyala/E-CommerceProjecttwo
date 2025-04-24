package com.example.EcommerceProject.Controller;
import com.example.EcommerceProject.Model.Admin;
import com.example.EcommerceProject.Model.Order;
import com.example.EcommerceProject.Model.Product;
import com.example.EcommerceProject.Model.User;
import com.example.EcommerceProject.Service.AdminService;
import com.example.EcommerceProject.Service.OrderService;
import com.example.EcommerceProject.Service.ProductService;
import com.example.EcommerceProject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.Date;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService; // Spring will now be able to inject this
    @Autowired
    private OrderService orderService;
    @GetMapping("/verify")
    public String verifyCredentials(@ModelAttribute("admin") Admin admin, Model model) {
        if (adminService.verifyCredentials(admin.getEmail(), admin.getPassword())) {
            return "redirect:/admin/home";
        }
        model.addAttribute("error", "Invalid email or password");
        return "login";
    }

    @GetMapping("/admin/home")
    public String adminHomePage(Model model) {
        model.addAttribute("addList", adminService.getAllAdmin());
        model.addAttribute("userList", userService.getAllUser());
        model.addAttribute("orderList", orderService.getAllOrders());
        model.addAttribute("productList", productService.getAllProduct());
        return "AdminHomePage";
    }

    @GetMapping("/add/admin")
    public String createAdmin() {
        return "AddAdmin";
    }

    @PostMapping("/add/admin")
    public String createAdmin(Admin admin) {
        adminService.createUser(admin);
        return "/admin/home";
    }

    @GetMapping("/update/admin/{id}")
    public String updateAdmin(@PathVariable Long id, Model model) {
        model.addAttribute("admin", adminService.getAdminId(id));
        return "UpdateAdmin";
    }

    @PostMapping("/update/admin")
    public String updateAdmin(Admin admin) {
        adminService.updateAdmin(admin);
        return "redirect:/admin/home";
    }

    @DeleteMapping("/delete/admin/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "redirect:/admin/home";
    }

    @PostMapping("/user/login")
    public String userLogin(@ModelAttribute("user") User user, Model model) {
        if (userService.verifyCredentials(user.getEmail(), user.getPassword())) {
            user = userService.findUserByEmail(user.getEmail());
            model.addAttribute("orderList", orderService.findOrdersByUser(user));
            return "ProductPage";
        }
        model.addAttribute("error", "Invalid email or password");
        return "Login";
    }

    @GetMapping("/product/search")
    public String productSearch(String name, Model model, Principal principal) {
        Product product = productService.findProductByName(name);
        User user = userService.findUserByEmail(principal.getName());
        if (product != null) {
            model.addAttribute("orderList", orderService.findOrdersByUser(user));
            model.addAttribute("product", product);
            return "Product Page";
        }
        model.addAttribute("error","Sorry, product was not found...");
        model.addAttribute("orderList", orderService.findOrdersByUser(user));
        return "Product Page";
    }

    @GetMapping("/place/order")
    public String placeOrder(Principal principal, @ModelAttribute("order") Order order, Model model) {
        String email = principal.getName();
        User user = userService.findUserByEmail(email);
        double totalAmount = order.getPrice() * order.getQuantity();
        order.setAmount(totalAmount);
        order.setUser(user);
        order.setDate(new Date());
        orderService.createOrder(order);
        model.addAttribute("amount", totalAmount);
        return "OrderStatus";
    }
}