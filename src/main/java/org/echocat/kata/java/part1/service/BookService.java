package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.models.Genre;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface BookService {
    Iterable<Book> findAll();

    Set<Book> findByGenres(Set<Genre> genres);

    Page<Book> getBookPagination(int page,int size);

    Iterable<Book> findByTitle(String title);

    Iterable<Book> findByGenresAndTitle(Set<Genre> genre,String title);

    Book findById(Long id);

    Book update(Book book, Long id);

    Book save(Book book);

    boolean existsById(Long id);

    void deleteById(Long id);
}
