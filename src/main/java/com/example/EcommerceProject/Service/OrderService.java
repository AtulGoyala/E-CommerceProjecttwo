package com.example.EcommerceProject.Service;

import com.example.EcommerceProject.Model.Order;
import com.example.EcommerceProject.Model.User;
import com.example.EcommerceProject.Repository.OrderRepo;
import com.example.EcommerceProject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserRepo userRepo;

    public List<Order> getAllOrders() {

        return orderRepo.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order with id " + id + " not found"));
    }

    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public void updateOrder(Order order) {
        orderRepo.findById(order.getId())
                .orElseThrow(() -> new RuntimeException("Order with id " + order.getId() + " not found"));
        orderRepo.save(order);
    }
    public void deleteOrder(Long id) {
        orderRepo.findById(id).orElseThrow(() ->
                new RuntimeException("Order with id " + id + " not found"));
        orderRepo.deleteById(id);
    }
    public List<Order>findOrdersByUser(User user){
    return orderRepo.findByUser((org.apache.catalina.User) user);

    }
}
