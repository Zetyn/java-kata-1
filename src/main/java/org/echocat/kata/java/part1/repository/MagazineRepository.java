//package org.echocat.kata.java.part1.repository;
//
//import org.echocat.kata.java.part1.models.Magazine;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface MagazineRepository extends CrudRepository<Magazine, String> {
//    Page<Magazine> findAll(Pageable page);
//
//    Magazine findByIsbn(String isbn);
//
//    boolean existsById(Long id);
//
//    Magazine findById(Long id);
//
//    void deleteById(Long id);
//}
