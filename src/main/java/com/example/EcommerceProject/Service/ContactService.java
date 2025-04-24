package com.example.EcommerceProject.Service;

import com.example.EcommerceProject.Model.Message;
import com.example.EcommerceProject.Repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;


    public List<Message> getAllMessages() {
        return contactRepo.findAll();
    }
        public Message getMessageById(Long id) {
        return contactRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Message with id " + id + " not found"));
    }
        public void createMessage(Message message) {
        // Check for any validation if needed
        if (message == null) {
            throw new IllegalArgumentException("Message cannot be null");
        }
        contactRepo.save(message); // Save the message to the database
    }
    public void updateMessage(Message message) {
        contactRepo.findById(message.getId())
                .orElseThrow(() -> new RuntimeException("Message with id " + message.getId() + " not found"));
        contactRepo.save(message); // Save the updated message
    }
    public void deleteMessage(Long id) {
        contactRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Message with id " + id + " not found"));
        contactRepo.deleteById(id); // Delete the message from the database
    }

    // Find a message by name
    public Message findMessageByName(String name) {
        return contactRepo.findByName(name); // Assuming you have a method to find by name
    }
}
