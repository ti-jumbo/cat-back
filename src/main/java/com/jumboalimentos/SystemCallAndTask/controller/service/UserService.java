package com.jumboalimentos.SystemCallAndTask.controller.service;

import com.jumboalimentos.SystemCallAndTask.UserRepository;
import com.jumboalimentos.SystemCallAndTask.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean existsByEmail(String email) {
        return  userRepository.existsByEmail(email);
    }

    public boolean existsByEmailAndAccessKey(String email, String accessKey) {
        return userRepository.existsByEmailAndAccessKey(email, accessKey);
    }

    public User createUser(User user) {
        if(existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("Usúario já cadastrado com este email");
        } else {
            user.setCreatedAt(LocalDateTime.now());
            return userRepository.save(user);
        }
    }
}
