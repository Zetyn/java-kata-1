package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Book;
import org.springframework.stereotype.Service;

@Service
public interface BookService {
    Iterable<Book> findAll();

    Book findById(Long id);

    Book update(Book book, Long id);

    Book save(Book book);

    boolean existsById(Long id);

    void deleteById(Long id);
}
