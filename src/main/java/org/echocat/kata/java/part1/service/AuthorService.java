package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.models.Magazine;

public interface AuthorService {
    Author update(Author author, Long id);

    Author save(Author author);

    Iterable<Author> findAll();

    Author findById(Long id);

    Author findByEmail(String email);

    boolean existsById(Long id);

    void deleteById(Long id);
}
