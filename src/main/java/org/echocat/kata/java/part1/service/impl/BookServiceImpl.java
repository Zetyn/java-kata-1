package org.echocat.kata.java.part1.service.impl;

import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.repository.BookRepository;
import org.echocat.kata.java.part1.service.AuthorService;
import org.echocat.kata.java.part1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book update(Book book,Long id) {
        Book updateBook = bookRepository.findById(id);
        updateBook.setTitle(book.getTitle());
        updateBook.setIsbn(book.getIsbn());
        updateBook.getAuthors().addAll(book.getAuthors());
        updateBook.setDescription(book.getDescription());
        return bookRepository.save(updateBook);
    }

    @Override
    public Book save(Book book) {
        Book newBook = new Book();
        newBook.setTitle(book.getTitle());
        newBook.setIsbn(book.getIsbn());
        newBook.setDescription(book.getDescription());
        newBook.getAuthors()
                .addAll(book
                        .getAuthors()
                        .stream()
                        .map(a ->{
                            Author aa = authorService.findByEmail(a.getEmail());
                            aa.getBooks().add(newBook);
                            return aa;
                        }).collect(Collectors.toSet()));
        return bookRepository.save(newBook);
    }

    @Override
    public boolean existsById(Long id) {
        return bookRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
