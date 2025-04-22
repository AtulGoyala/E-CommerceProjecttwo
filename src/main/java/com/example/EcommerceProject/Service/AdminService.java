package com.example.EcommerceProject.Service;

import com.example.EcommerceProject.Model.Admin;
import com.example.EcommerceProject.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    public void addAdmin(Admin admin) {
        adminRepo.save(admin);
    }

    public List<Admin> getAllAdmin() {
        return adminRepo.findAll();
    }

    public Admin getAdminId(Long id) {
        return adminRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin with id " + id + " not found"));
    }

    public void updateAdmin(Admin admin) {
        adminRepo.findById(admin.getId())
                .orElseThrow(() -> new RuntimeException("Admin with id " + admin.getId() + " not found"));
        adminRepo.save(admin);
    }
        public void deleteAdmin(Long id) {
        adminRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin with id " + id + " not found"));
        adminRepo.deleteById(id);
    }

    public boolean verifyCredentials(String email, String password) {
        Admin admin = adminRepo.findByEmail(email);
        return admin != null && admin.getPassword().equals(password);
    }
    public boolean verfiyCredentials(String email, String password)
    {
        return false;
    }
    public void createUser(Admin admin) {

        adminRepo.save(admin);
    }
}
