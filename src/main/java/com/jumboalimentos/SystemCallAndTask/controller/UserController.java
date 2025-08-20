package com.jumboalimentos.SystemCallAndTask.controller;

import com.jumboalimentos.SystemCallAndTask.entities.User;
import com.jumboalimentos.SystemCallAndTask.controller.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getuser/{email}")
    public ResponseEntity<Boolean> checkUserExists(@PathVariable String email) {
        try {
            boolean userExists = userService.existsByEmail(email);
            System.out.println(userExists);
            return ResponseEntity.ok(userExists);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User loginR) {
        try {
            boolean login = userService.existsByEmailAndAccessKey(loginR.getEmail(), loginR.getAccessKey());
            if(login) {
                return ResponseEntity.status(200).body(null);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/createuser")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        try {
            User savedUser = userService.createUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}

