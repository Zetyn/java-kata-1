package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.Genre;
import org.echocat.kata.java.part1.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library")
public class GenresController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genres")
    public Iterable<Genre> getGenres() {
        return genreService.findAll();
    }
}
