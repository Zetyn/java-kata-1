package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.service.AuthorService;
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
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @PutMapping("/profile")
    public ResponseEntity<?> editUser(@RequestBody Author author) {
        authorService.update(author, author.getId());
        return ResponseEntity.ok(author);
    }

/*
    @PostMapping("/profile")
    public Book myBooks(@RequestBody Author author) {
        return bookService.findByAuthors(author.getEmail());
    }

 */
}
