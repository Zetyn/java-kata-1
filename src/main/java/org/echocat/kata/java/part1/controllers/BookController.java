package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.models.BookText;
import org.echocat.kata.java.part1.models.BookTextRequestDTO;
import org.echocat.kata.java.part1.models.Genre;
import org.echocat.kata.java.part1.service.BookService;
import org.echocat.kata.java.part1.service.BookTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Set;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookTextService bookTextService;

    //--------------Get----------------------------------
    @GetMapping("/books")
    public ResponseEntity<Iterable<Book>> getBooks(@RequestParam(name = "section", defaultValue = "all") String section,
                                   @RequestParam(name = "genres", required = false) Set<Genre> genres,
                                   @RequestParam(name = "search", required = false) String title) {
//        if (genres != null && title != null) {
//            return  new ResponseEntity<>(bookService.findByGenresAndTitle(genres,title),HttpStatus.OK);
//        }
        if (genres != null) {
            return new ResponseEntity<>(bookService.findByGenres(genres),HttpStatus.OK);
        }
        if (title != null) {
            return new ResponseEntity<>(bookService.findByTitle(title),HttpStatus.OK);
        }
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.OK);

//        if (section.equals("all")) {
//            return bookService.findAll();
//        } else if (section.equals("byGenres")) {
//            return bookService.findByGenres(genres);
//        } else
//            return bookService.findByTitle(title);
    }

    @GetMapping("/books/{id}/v{volumeNumber}/c{chapterNumber}")
    public ResponseEntity<?> getBookText(@PathVariable("id") Long id,
                                         @PathVariable("volumeNumber") int volumeNumber,
                                         @PathVariable("chapterNumber") int chapterNumber) {
        BookText bookText = bookTextService.findByBookIdAndChapterAndVolume(id,chapterNumber,volumeNumber);
        return ResponseEntity.ok()
                .body(bookText.getText());
    }

    @GetMapping("/books/{id}")
    public Book bookDetails(@PathVariable("id") Long id) {
        if (bookService.existsById(id)) {
            return bookService.findById(id);
        }
        return null;
    }

//    @GetMapping("/books")
//    public Set<Book> getBookByGenres(@RequestParam(name = "genres", required = false) Set<Genre> genres) {
//        return bookService.findByGenres(genres);
//    }


//    @GetMapping("/books/search={title}")
//    public ResponseEntity<Iterable<Book>> searchBooks(@PathVariable("title") String title) {
//        return new ResponseEntity<>(bookService.findByTitle(title), HttpStatus.OK);
//    }

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

    @PostMapping("/books/{id}/add-chapter")
    public ResponseEntity<?> createChapter(@ModelAttribute BookTextRequestDTO request,
                                           @PathVariable("id") long id) {
        try {
            bookTextService.save(request.getFile(), request.getChapter(), request.getVolume(),bookService.findById(id));
            return ResponseEntity.status(HttpStatus.CREATED).body("created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failed");
        }
    }


    //--------------Delete----------------------------------
    @Transactional
    @DeleteMapping("/books/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
