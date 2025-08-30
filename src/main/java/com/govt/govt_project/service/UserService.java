package com.govt.govt_project.service;
import com.govt.govt_project.Repository.UserRepository;
import com.govt.govt_project.model.RegisterDTO;
import com.govt.govt_project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public String data(RegisterDTO dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            return "Email already exists!";
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));

        User newUser = new User();
        newUser.setFirstName(dto.getFirstName());
        newUser.setLastName(dto.getLastName());
        newUser.setEmail(dto.getEmail());
        newUser.setCountry(dto.getCountry());
        newUser.setPassword(dto.getPassword());

        userRepository.save(newUser);

        return "User registered successfully!";
    }


    public User findByEmailAndPassword(String email, String rawPassword) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(rawPassword, user.getPassword())) {
                return user;
            }
        }
        return null;
    }


}
