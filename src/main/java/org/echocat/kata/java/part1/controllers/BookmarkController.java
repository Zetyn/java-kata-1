package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.BookmarkRequestDTO;
import org.echocat.kata.java.part1.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/library")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping("/books/bookmark/{id}")
    public ResponseEntity<?> getBookmark(@AuthenticationPrincipal User user,@PathVariable("id") Long bookId) {
        return new ResponseEntity<>(user.getUsername(),HttpStatus.OK);
    }

    @PostMapping("/books/**")
    public ResponseEntity<?> addBookmark(@RequestBody BookmarkRequestDTO request) {
        return new ResponseEntity<>(bookmarkService.saveBookmark(request), HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/books/bookmarkDelete")
    public ResponseEntity<?> deleteBookmark (@RequestBody BookmarkRequestDTO request) {
        bookmarkService.deleteBookmark(request);
        return ResponseEntity.ok().build();
    }
}
