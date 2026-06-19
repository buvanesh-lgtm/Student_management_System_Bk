package com.example.Advanced_SMS.Controller;

import com.example.Advanced_SMS.DTO.LoginRequest;
import com.example.Advanced_SMS.DTO.LoginResponse;
import com.example.Advanced_SMS.Entity.User;
import com.example.Advanced_SMS.Repository.UserRepository;
import com.example.Advanced_SMS.Security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // POST /api/auth/login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        return userRepository.findByUsername(request.getUsername())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .map(user -> {
                    String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
                    return ResponseEntity.ok(new LoginResponse(token, user.getUsername(), user.getRole()));
                })
                .orElse(ResponseEntity.status(401).build());
    }

    // POST /api/auth/register  ← Use once to create your admin account, then remove or restrict
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody LoginRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole("ADMIN");
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully");
    }
}