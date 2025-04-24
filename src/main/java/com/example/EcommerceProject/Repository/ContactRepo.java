package com.example.EcommerceProject.Repository;

import com.example.EcommerceProject.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Message, Long> {
    Message findByName(String name); // Custom query to find messages by name
}
