package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.models.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    Page<Book> findAll(Pageable page);

    Set<Book> findByGenres(Genre genre);

    Iterable<Book> findByTitleContainingIgnoreCase(String title);

    Iterable<Book> findByGenresAndTitleContainingIgnoreCase(Genre genres, String title);

    Book findById(Long id);

    Book findByIsbn(String isbn);

    boolean existsById(Long id);

    void deleteById(Long id);

}
