package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Genre;
import org.springframework.stereotype.Service;

@Service
public interface GenreService {
    Iterable<Genre> findAll();
}
