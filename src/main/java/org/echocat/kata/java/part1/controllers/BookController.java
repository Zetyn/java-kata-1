package org.echocat.kata.java.part1.controllers;

import org.echocat.kata.java.part1.models.*;
import org.echocat.kata.java.part1.service.BookService;
import org.echocat.kata.java.part1.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ChapterService chapterService;

    //--------------Get----------------------------------
    @GetMapping("/books")
    public ResponseEntity<Iterable<Book>> getBooks(@RequestParam(name = "section", defaultValue = "all") String section,
                                   @RequestParam(name = "genres", required = false) Set<Genre> genres,
                                   @RequestParam(name = "search", required = false) String title) {
        if (genres != null) {
            return new ResponseEntity<>(bookService.findByGenres(genres),HttpStatus.OK);
        }
        if (title != null) {
            return new ResponseEntity<>(bookService.findByTitle(title),HttpStatus.OK);
        }
        return new ResponseEntity<>(bookService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/book/{id}/v{volumeNumber}/c{chapterNumber}/text")
    public ResponseEntity<?> getChapterText(@PathVariable("id") Long id,
                                         @PathVariable("volumeNumber") int volumeNumber,
                                         @PathVariable("chapterNumber") int chapterNumber) {
        Chapter chapter = chapterService.findByBookIdAndChapterAndVolume(id,chapterNumber,volumeNumber);
        String byteToString = new String(chapter.getText());
        return ResponseEntity.ok()
                .body(byteToString);
    }

    @GetMapping("/book/{id}/v{volumeNumber}/c{chapterNumber}")
    public ResponseEntity<?> getChapter(@PathVariable("id") Long id,
                                            @PathVariable("volumeNumber") int volumeNumber,
                                            @PathVariable("chapterNumber") int chapterNumber) {
        Chapter chapter = chapterService.findByBookIdAndChapterAndVolume(id,chapterNumber,volumeNumber);
        chapter.setText(null);
        return ResponseEntity.ok()
                .body(chapter);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<?> bookDetails(@PathVariable("id") Long id) {
        if (bookService.existsById(id)) {
            return ResponseEntity.ok()
                    .body(bookService.findById(id));
        }
        return null;
    }

    @GetMapping("/book/{id}/chapterCount")
    public ResponseEntity<?> chapterCount(@PathVariable("id") Long id) {
        if (bookService.existsById(id)) {
            return ResponseEntity.ok()
                    .body(chapterService.findAllChaptersByBook_Id(id));
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
    @PutMapping("/book/edit/{id}")
    public ResponseEntity<?> updateBook(@RequestBody BookRequestDTO book, @AuthenticationPrincipal User user) {
        bookService.save(book,user);
        return ResponseEntity.ok(book);
    }

    //--------------Post----------------------------------

    @PostMapping("/book/add-book")
    public ResponseEntity<?> createBook(@RequestBody BookRequestDTO book, @AuthenticationPrincipal User user) {
        return new ResponseEntity<>(bookService.save(book,user), HttpStatus.CREATED);
    }

    @PostMapping("/book/{id}/add-chapter")
    public ResponseEntity<?> createChapter(@RequestBody ChapterRequestDTO request,
                                           @PathVariable("id") Long id) {
        try {
            chapterService.save(request);
            return ResponseEntity.status(HttpStatus.CREATED).body("created");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failed");
        }
    }


    //--------------Delete----------------------------------
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
