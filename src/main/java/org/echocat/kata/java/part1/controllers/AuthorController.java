package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/library")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    //--------------Get----------------------------------
    @GetMapping("/authors")
    public Iterable<Author> getAuthors() {
        return authorService.findAll();
    }

    @GetMapping("/authors/{id}")
    public Author authorDetails(@PathVariable("id") Long id) {
        if (authorService.existsById(id)) {
            return authorService.findById(id);
        }
        return null;
    }

    //-----------------Put-------------------------------
    @PutMapping("/authors/edit/{id}")
    public ResponseEntity<?> updateAuthor(@PathVariable("id") Long id, @RequestBody Author author) {
        authorService.update(author, id);
        return ResponseEntity.ok(author);
    }

    //--------------Post--------------------------------
    @PostMapping("/authors/add-author")
    public ResponseEntity<?> createAuthor(@RequestBody Author author) {
        return new ResponseEntity<>(authorService.save(author), HttpStatus.CREATED);
    }

    //---------------Delete-----------------------------
    @Transactional
    @DeleteMapping("/authors/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
