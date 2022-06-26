//package org.echocat.kata.java.part1.controllers;
//
//import org.echocat.kata.java.part1.models.Magazine;
//import org.echocat.kata.java.part1.service.MagazineService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.transaction.Transactional;
//
//@RestController
//@RequestMapping("/library")
//public class MagazineController {
//
//    @Autowired
//    private MagazineService magazineService;
//
//    //--------------Get----------------------------------
//    @GetMapping("/magazines")
//    public Iterable<Magazine> getMagazines() {
//        return magazineService.findAll();
//    }
//
//    @GetMapping("/magazines/{id}")
//    public Magazine magazineDetails(@PathVariable("id") Long id) {
//        if (magazineService.existsById(id)) {
//            return magazineService.findById(id);
//        }
//        return null;
//    }
//
//    //--------------Put----------------------------------
//    @PutMapping("/magazines/edit/{id}")
//    public ResponseEntity<?> updateMagazine(@PathVariable("id") Long id, @RequestBody Magazine magazine) {
//        magazineService.update(magazine,id);
//        return  ResponseEntity.ok(magazine);
//    }
//
//    //--------------Post----------------------------------
//    @PostMapping("/magazines/add-magazine")
//    public ResponseEntity<?> createMagazine(@RequestBody Magazine magazine) {
//        return new ResponseEntity<>(magazineService.save(magazine), HttpStatus.CREATED);
//    }
//
//    //--------------Delete----------------------------------
//    @Transactional
//    @DeleteMapping("/magazines/{id}")
//    public ResponseEntity<?> deleteMagazine(@PathVariable("id") Long id) {
//        magazineService.deleteById(id);
//        return ResponseEntity.ok().build();
//    }
//}
