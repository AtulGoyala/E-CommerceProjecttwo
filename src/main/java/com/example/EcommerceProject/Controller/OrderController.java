package com.example.EcommerceProject.Controller;
import com.example.EcommerceProject.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;



}