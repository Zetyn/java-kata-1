package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    Iterable<Book> findAll();

    Page<Book> getBookPagination(int page,int size);

    List<Book> findByTitle(String title);

    Book findById(Long id);

    Book update(Book book, Long id);

    Book save(Book book);

    boolean existsById(Long id);

    void deleteById(Long id);
}
