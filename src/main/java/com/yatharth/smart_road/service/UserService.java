package com.yatharth.smart_road.service;

import com.yatharth.smart_road.dto.AuthDTOs.AuthResponse;
import com.yatharth.smart_road.dto.AuthDTOs.LoginRequest;
import com.yatharth.smart_road.dto.AuthDTOs.RegisterRequest;
import com.yatharth.smart_road.dto.GoogleAuthRequest;
import com.yatharth.smart_road.entity.User;
import com.yatharth.smart_road.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponse register(RegisterRequest request) {
        User existingUser = userRepository.findByUsername(request.getUsername());
        if (existingUser != null) {
            throw new IllegalArgumentException("Account already registered! Username '" + request.getUsername() + "' is already in use. Please sign in instead.");
        }

        if (request.getEmail() != null && !request.getEmail().trim().isEmpty()) {
            User existingEmail = userRepository.findByEmail(request.getEmail().trim());
            if (existingEmail != null) {
                throw new IllegalArgumentException("Account already registered! Email '" + request.getEmail() + "' is already in use. Please sign in instead.");
            }
        }

        String role = (request.getRole() != null && !request.getRole().isEmpty())
                ? request.getRole()
                : "ROLE_USER";

        if (!role.startsWith("ROLE_")) {
            role = "ROLE_" + role.toUpperCase();
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(role);

        User saved = userRepository.save(user);
        String token = jwtService.generateToken(saved.getUsername(), saved.getRole());

        return new AuthResponse(token, saved.getUsername(), saved.getEmail(), saved.getRole());
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.getUsername());
        if (user == null) {
            throw new IllegalArgumentException("Invalid username or password.");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Invalid username or password.");
        }

        String token = jwtService.generateToken(user.getUsername(), user.getRole());
        return new AuthResponse(token, user.getUsername(), user.getEmail(), user.getRole());
    }

    public AuthResponse processGoogleLogin(GoogleAuthRequest request) {
        String email = request.getEmail();
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email address is required for Google Sign-In.");
        }

        String rawPassword = request.getPassword();
        if (rawPassword == null || rawPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required to authenticate Google account.");
        }

        User user = userRepository.findByEmail(email.trim());
        if (user == null) {
            String username = (request.getName() != null && !request.getName().isEmpty())
                    ? request.getName().replaceAll("\\s+", "_").toLowerCase()
                    : email.split("@")[0];
            user = userRepository.findByUsername(username);
        }

        if (user == null) {
            throw new IllegalArgumentException("Account not registered! This Google account (" + email + ") is not registered yet. Please click Register first.");
        }

        // Verify password for existing Google account
        if (!passwordEncoder.matches(rawPassword, user.getPassword())) {
            throw new IllegalArgumentException("Invalid Google Account password. Authentication failed.");
        }

        String token = jwtService.generateToken(user.getUsername(), user.getRole());
        return new AuthResponse(token, user.getUsername(), user.getEmail(), user.getRole());
    }

    public Map<String, Object> processGoogleRegister(GoogleAuthRequest request) {
        String email = request.getEmail();
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email address is required for Google Registration.");
        }

        String rawPassword = request.getPassword();
        if (rawPassword == null || rawPassword.trim().isEmpty()) {
            throw new IllegalArgumentException("Password is required to register Google account.");
        }

        String username = (request.getName() != null && !request.getName().isEmpty())
                ? request.getName().replaceAll("\\s+", "_").toLowerCase()
                : email.split("@")[0];

        // Duplicate checks
        User existingEmail = userRepository.findByEmail(email.trim());
        if (existingEmail != null) {
            throw new IllegalArgumentException("Account already registered! Google account '" + email + "' is already in use. Please sign in instead.");
        }

        User existingUsername = userRepository.findByUsername(username);
        if (existingUsername != null) {
            throw new IllegalArgumentException("Account already registered! Username '" + username + "' is already in use. Please sign in instead.");
        }

        String role = (request.getRole() != null && !request.getRole().isEmpty()) ? request.getRole() : "ROLE_USER";
        if (!role.startsWith("ROLE_")) role = "ROLE_" + role.toUpperCase();

        User user = new User();
        user.setUsername(username);
        user.setEmail(email.trim());
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(role);

        User saved = userRepository.save(user);

        return Map.of(
                "username", saved.getUsername(),
                "email", saved.getEmail(),
                "message", "Account registered successfully! Please sign in with your credentials."
        );
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}