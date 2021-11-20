package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.models.Magazine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazineRepository extends CrudRepository<Magazine, String> {
    Magazine findByIsbn(String isbn);

    boolean existsById(Long id);

    Magazine findById(Long id);

    void deleteById(Long id);
}
