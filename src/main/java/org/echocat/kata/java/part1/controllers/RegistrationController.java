package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.AuthenticationRequestDTO;
import org.echocat.kata.java.part1.models.User;
import org.echocat.kata.java.part1.repository.UserRepository;
import org.echocat.kata.java.part1.security.JwtAuthenticationException;
import org.echocat.kata.java.part1.security.JwtTokenProvider;
import org.echocat.kata.java.part1.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/library")
public class RegistrationController {

    private final UserRepository userRepository;

    private final UserService userService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;
    //---------------------Constructor------------------------------
    public RegistrationController(UserRepository userRepository, UserService userService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    //---------------------Sign in------------------------------
    @PostMapping("/login/signIn")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO request, HttpServletResponse resp) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            User user = userRepository.findByEmail(request.getEmail());
            String token = jwtTokenProvider.createToken(request.getEmail(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", request.getEmail());
            response.put("token", token);
            response.put("firstName", user.getFirstName());
            response.put("lastName", user.getLastName());
            response.put("id", user.getId());
            response.put("role", user.getRole());

            return ResponseEntity.ok(response);
        } catch (JwtAuthenticationException e) {
            return new ResponseEntity<>("Invalid email/password", HttpStatus.FORBIDDEN);
        }
    }
    //---------------------Logout------------------------------
    @PostMapping()
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
    //---------------------Create user------------------------------
    @PostMapping("/login/signUp")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User newUser = userRepository.findByEmail(user.getEmail());
        if (newUser == null) {
            return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}
