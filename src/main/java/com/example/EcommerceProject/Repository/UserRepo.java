package com.example.EcommerceProject.Repository;

import com.example.EcommerceProject.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long>
{
     User findByEmail(String email);
}
