package com.example.EcommerceProject.Repository;

import com.example.EcommerceProject.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Message, Long> {
    Message findByName(String name); // optional
}
