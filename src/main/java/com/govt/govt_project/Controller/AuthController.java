package com.govt.govt_project.Controller;

import com.govt.govt_project.Repository.UserRepository;
import com.govt.govt_project.model.LoginDTO;
import com.govt.govt_project.model.RegisterDTO;
import com.govt.govt_project.model.UpdateUserDTO;
import com.govt.govt_project.model.User;
import com.govt.govt_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody RegisterDTO registerDTO) {
        return userService.data(registerDTO);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO loginRequest) {
        User user = userService.findByEmailAndPassword(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        );

        if (user == null) {
            return "Invalid email or password!";
        }

        return "Login successful!";
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody UpdateUserDTO registerDTO) {
        return userService.updateUser(registerDTO);
    }


}
