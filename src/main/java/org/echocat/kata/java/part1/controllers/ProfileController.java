package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.User;
import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.service.UserService;
import org.echocat.kata.java.part1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @PutMapping("/profile")
    public ResponseEntity<?> editUser(@RequestBody User user) {
        userService.update(user, user.getId());
        return ResponseEntity.ok(user);
    }

/*
    @PostMapping("/profile")
    public Book myBooks(@RequestBody Author author) {
        return bookService.findByAuthors(author.getEmail());
    }

 */
}
