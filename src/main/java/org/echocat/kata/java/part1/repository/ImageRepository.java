package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.models.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends CrudRepository<Image,String> {
    void deleteById(Long id);
}
