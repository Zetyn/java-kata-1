package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.models.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, String> {
    Author findById(Long id);

    Author findByEmail(String email);

    void deleteById(Long id);

    boolean existsById(Long id);
}
