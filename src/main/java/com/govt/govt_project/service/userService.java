package com.govt.govt_project.service;
import com.govt.govt_project.model.User;
import com.govt.govt_project.userRepository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class userService {

    @Autowired
    private userRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            return "Username already exists!";
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            return "Email already exists!";
        }

//        if (!user.getPassword()) {
//            return "Passwords do not match!";
//        }

        // Encrypt password
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save user (username is the ID)
        userRepository.save(user);
        return "User registered successfully!";
    }

    public User findByEmail(String email, String password) {
        return userRepository.findByEmailAndPassword(email, passwordEncoder.encode(password)).orElse(null);
    }


}
