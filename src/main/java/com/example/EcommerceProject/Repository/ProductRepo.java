package com.example.EcommerceProject.Repository;

import com.example.EcommerceProject.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long> {
 Product findByName(String name); // Corrected parameter name to 'name'
}