package com.example.sample1.service.impl;

import com.example.sample1.model.User;
import com.example.sample1.repository.UserRepository;
import com.example.sample1.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String name){
        return userRepository.findByUsername(name);
    }

    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }
}
