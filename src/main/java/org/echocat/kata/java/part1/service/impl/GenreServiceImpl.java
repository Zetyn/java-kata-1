package org.echocat.kata.java.part1.service.impl;

import org.echocat.kata.java.part1.models.Genre;
import org.echocat.kata.java.part1.repository.GenreRepository;
import org.echocat.kata.java.part1.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Override
    public Iterable<Genre> findAll() {
        return genreRepository.findAll();
    }
}
