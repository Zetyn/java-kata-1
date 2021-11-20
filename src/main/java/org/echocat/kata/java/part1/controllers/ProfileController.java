package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library/profile")
public class ProfileController {

    @Autowired
    private AuthorService authorService;

    @GetMapping()
    public Author userProfile() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        Author author = authorService.findByEmail(email);
        return author;
    }
}
