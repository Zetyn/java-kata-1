package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.AuthenticationRequestDTO;
import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.repository.AuthorRepository;
import org.echocat.kata.java.part1.security.JwtAuthenticationException;
import org.echocat.kata.java.part1.security.JwtTokenProvider;
import org.echocat.kata.java.part1.service.AuthorService;

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

    private final AuthorRepository authorRepository;

    private final AuthorService authorService;

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;
    //---------------------Constructor------------------------------
    public RegistrationController(AuthorRepository authorRepository, AuthorService authorService, AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider) {
        this.authorRepository = authorRepository;
        this.authorService = authorService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
    }
    //---------------------Sign in------------------------------
    @PostMapping("/login/signIn")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO request, HttpServletResponse resp) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            Author user = authorRepository.findByEmail(request.getEmail());
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
    public ResponseEntity<?> createUser(@RequestBody Author user) {
        Author newUser = authorRepository.findByEmail(user.getEmail());
        if (newUser == null) {
            return new ResponseEntity<>(authorService.save(user), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }
}
