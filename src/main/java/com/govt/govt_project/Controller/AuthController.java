package com.govt.govt_project.Controller;

import com.govt.govt_project.model.LoginDTO;
import com.govt.govt_project.model.User;
import com.govt.govt_project.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private userService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginRequest) {
        User user = userService.findByEmail(loginRequest.getEmail(), loginRequest.getPassword());

        if (user == null) {
            return "User not found!";
        }
        return "Login successful!";
    }
}
