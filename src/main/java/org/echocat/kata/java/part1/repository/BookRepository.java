package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    Page<Book> findAll(Pageable page);

    List<Book> findByTitleStartingWith(String title);

    List<Book> findByTitleEndingWith(String title);

    List<Book> findByTitleContainingIgnoreCase(String title);

    Book findById(Long id);

    Book findByIsbn(String isbn);

    boolean existsById(Long id);

    void deleteById(Long id);

}
