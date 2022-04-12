package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.Bookmark;
import org.echocat.kata.java.part1.models.User;
import org.echocat.kata.java.part1.service.BookmarkService;
import org.echocat.kata.java.part1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping("/profile/{id}")
    public ResponseEntity<Iterable<Bookmark>> getBookmarks(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookmarkService.findByUserId(id),HttpStatus.OK);
    }

    @PutMapping("/profile")
    public ResponseEntity<?> editUser(@RequestBody User user) {
        userService.update(user, user.getId());
        return ResponseEntity.ok(user);
    }

}
