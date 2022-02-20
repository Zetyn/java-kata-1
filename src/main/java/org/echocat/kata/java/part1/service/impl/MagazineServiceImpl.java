package org.echocat.kata.java.part1.service.impl;

import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.models.Magazine;
import org.echocat.kata.java.part1.repository.MagazineRepository;
import org.echocat.kata.java.part1.service.AuthorService;
import org.echocat.kata.java.part1.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MagazineServiceImpl implements MagazineService {

    @Autowired
    private MagazineRepository magazineRepository;

    @Autowired
    private AuthorService authorService;

    @Override
    public Page<Magazine> getMagazinePagination(int page, int size) {
        Pageable pageable = PageRequest.of(page,size, Sort.Direction.ASC,"title");
        return magazineRepository.findAll(pageable);
    }
    //---------------------Find------------------------------
    @Override
    public Iterable<Magazine> findAll() {
        return magazineRepository.findAll();
    }

    @Override
    public Magazine findById(Long id) {
        return magazineRepository.findById(id);
    }

    //---------------------Update------------------------------
    @Override
    public Magazine update(Magazine magazine, Long id) {
        Magazine updateMagazine = magazineRepository.findById(id);
        updateMagazine.setTitle(magazine.getTitle());
        updateMagazine.setIsbn(magazine.getIsbn());
        updateMagazine.getAuthors().addAll(magazine.getAuthors());
        updateMagazine.setPublishedAt(magazine.getPublishedAt());
        return magazineRepository.save(updateMagazine);
    }

    //---------------------Save------------------------------
    @Override
    public Magazine save(Magazine magazine) {
        Magazine newMagazine = new Magazine();
        newMagazine.setTitle(magazine.getTitle());
        newMagazine.setIsbn(magazine.getIsbn());
        newMagazine.setPublishedAt(magazine.getPublishedAt());
        newMagazine.getAuthors()
                .addAll(
                        magazine.getAuthors()
                                .stream()
                                .map(author -> {
                                    Author author1 = authorService.findByEmail(author.getEmail());
                                    author1.getMagazines().add(newMagazine);
                                    return author1;
                                }).collect(Collectors.toSet())
                );
        return magazineRepository.save(newMagazine);
    }

    //---------------------Exists------------------------------
    @Override
    public boolean existsById(Long id) {
        return magazineRepository.existsById(id);
    }

    //---------------------Delete------------------------------
    @Override
    public void deleteById(Long id) {
        magazineRepository.deleteById(id);
    }
}
