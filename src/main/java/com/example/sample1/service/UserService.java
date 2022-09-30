package com.example.sample1.service;


import com.example.sample1.model.User;

import java.util.Optional;

public interface UserService {
	 public User getUser(String name);

	 public Optional<User> findById(Integer id);
}
