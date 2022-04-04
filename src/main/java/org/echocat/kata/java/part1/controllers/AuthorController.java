package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.User;
import org.echocat.kata.java.part1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/library")
public class AuthorController {

    @Autowired
    private UserService userService;

    //--------------Get----------------------------------
    @GetMapping("/authors")
    public Iterable<User> getAuthors() {
        return userService.findAll();
    }

    @GetMapping("/authors/{id}")
    public User authorDetails(@PathVariable("id") Long id) {
        if (userService.existsById(id)) {
            return userService.findById(id);
        }
        return null;
    }

    //-----------------Put-------------------------------
    @PutMapping("/authors/edit/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable("id") Long id, @RequestBody User user) {
        userService.update(user, id);
        return ResponseEntity.ok(user);
    }

    //--------------Post--------------------------------
    @PostMapping("/authors/add-author")
    public ResponseEntity<?> createAuthor(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    //---------------Delete-----------------------------
    @Transactional
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
