package com.example.EcommerceProject.Repository;

import com.example.EcommerceProject.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
 public interface AdminRepo extends JpaRepository<Admin,Long> {
    public Admin findByEmail(String email);

}
