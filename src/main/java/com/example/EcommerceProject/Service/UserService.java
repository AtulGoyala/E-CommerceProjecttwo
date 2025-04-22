package com.example.EcommerceProject.Service;

import com.example.EcommerceProject.Model.User;
import com.example.EcommerceProject.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userrepo;

    public List<User> getAllUser() {
        return userrepo.findAll();
    }

    public User getUserById(Long id) {
        return userrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
    }

    public void createUser(User user) {
        userrepo.save(user);
    }

    public void updateUser(User user) {
        userrepo.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User with id " + user.getId() + " not found"));
        userrepo.save(user);
    }

    public void deleteUser(Long id) {
        userrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        userrepo.deleteById(id);
    }
    public User findUserByEmail(String email){
        return userrepo.findByEmail(email);
    }public boolean verifyCredentials(String email, String password) {
        User user = userrepo.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

}

