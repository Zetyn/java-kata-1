package org.echocat.kata.java.part1.repository;


import org.echocat.kata.java.part1.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    Book findById(Long id);

    Book findByIsbn(String isbn);

    boolean existsById(Long id);

    void deleteById(Long id);

}
