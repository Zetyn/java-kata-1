package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.repository.BookRepository;
import org.echocat.kata.java.part1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    //--------------Get----------------------------------
    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public Book bookDetails(@PathVariable("id") Long id) {
        if (bookService.existsById(id)) {
            return bookService.findById(id);
        }
        return null;
    }

    @GetMapping("/books/search={title}")
    public ResponseEntity<List<Book>> searchBooks(@PathVariable("title") String title) {
        return new ResponseEntity<>(bookService.findByTitle(title), HttpStatus.OK);
    }

    @GetMapping("/books/{page}/{size}")
    public Page<Book> bookPagination(@PathVariable int page, @PathVariable int size) {
        return bookService.getBookPagination(page, size);
    }

    //--------------Put----------------------------------
    @PutMapping("/books/edit/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        bookService.update(book, id);
        return ResponseEntity.ok(book);
    }

    //--------------Post----------------------------------

    @PostMapping("/books/add-book")
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(bookService.save(book), HttpStatus.CREATED);
    }


    //--------------Delete----------------------------------
    @Transactional
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
