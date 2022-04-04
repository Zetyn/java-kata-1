package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends CrudRepository<Genre,Long> {
}
