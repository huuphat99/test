package com.example.sample1.repository;

import com.example.sample1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

}
