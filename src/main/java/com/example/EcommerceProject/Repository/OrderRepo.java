package com.example.EcommerceProject.Repository;

import com.example.EcommerceProject.Model.Order;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}



