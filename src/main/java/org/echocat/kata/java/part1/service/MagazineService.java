package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Magazine;

public interface MagazineService {
    Iterable<Magazine> findAll();

    Magazine findById(Long id);

    Magazine update(Magazine magazine,Long id);

    Magazine save(Magazine magazine);

    boolean existsById(Long id);

    void deleteById(Long id);
}
