package com.gym.controller;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.entity.User;
import com.gym.repository.UserRepository;

@RestController
@RequestMapping("/api/admin")
@Secured("ROLE_ADMIN")
public class AdminController {
    private final UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/memberships")
    public List<User> manageMemberships() {
        return userRepository.findAll();  
    }
}