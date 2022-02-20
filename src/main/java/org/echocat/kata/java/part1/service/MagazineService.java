package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Magazine;
import org.springframework.data.domain.Page;

public interface MagazineService {
    Iterable<Magazine> findAll();

    Page<Magazine> getMagazinePagination(int page, int size);

    Magazine findById(Long id);

    Magazine update(Magazine magazine,Long id);

    Magazine save(Magazine magazine);

    boolean existsById(Long id);

    void deleteById(Long id);
}
