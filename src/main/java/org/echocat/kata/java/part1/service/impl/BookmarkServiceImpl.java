package org.echocat.kata.java.part1.service.impl;

import org.echocat.kata.java.part1.models.*;
import org.echocat.kata.java.part1.repository.BookRepository;
import org.echocat.kata.java.part1.repository.BookmarkRepository;
import org.echocat.kata.java.part1.service.BookmarkService;
import org.echocat.kata.java.part1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookmarkServiceImpl implements BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserService userService;

    @Override
    public Iterable<Bookmark> findByUserId(Long id) {
        return bookmarkRepository.findByUserId(id);
    }

    @Override
    public Bookmark findByUserIdAndTitle(Long id, BookmarkEnum title) {
        return bookmarkRepository.findByUserIdAndTitle(id, title);
    }

    @Override
    public BookmarkEnum findByUserEmailAndBook(String userEmail, Long bookId) {
        Iterable<Bookmark> bookmarks = bookmarkRepository.findByUserEmail(userEmail);
        for (Bookmark bookmark: bookmarks) {
            Set<Book> books = bookmark.getBooks();
            for (Book book: books) {
                if (book.getId().equals(bookId)) {
                    return bookmark.getTitle();
                }
            }
        }
        return null;
    }

    @Override
    public Bookmark saveBookmark(BookmarkRequestDTO request) {
        Bookmark userBookmark = bookmarkRepository.findByUserIdAndTitle(request.getUserId(), request.getTitle());
        Iterable<Bookmark> allUserBookmark = bookmarkRepository.findByUserId(request.getUserId());
        identityCheck(request, allUserBookmark);
        if (userBookmark != null) {
            userBookmark.getBooks().add(bookRepository.findById(request.getBookId()));
            return bookmarkRepository.save(userBookmark);
        } else {
            Bookmark newUserBookmark = new Bookmark();
            newUserBookmark.setUser(userService.findById(request.getUserId()));
            newUserBookmark.setTitle(request.getTitle());
            Set<Book> books = new HashSet<>();
            books.add(bookRepository.findById(request.getBookId()));
            newUserBookmark.setBooks(books);
            return bookmarkRepository.save(newUserBookmark);
        }
    }

    private void identityCheck(BookmarkRequestDTO request, Iterable<Bookmark> allUserBookmark) {
        for (Bookmark bookmark : allUserBookmark) {
            Set<Book> books = bookmark.getBooks();
            for (Book book : books) {
                if (book.getId().equals(request.getBookId())) {
                    bookmark.getBooks().remove(book);
                    bookmarkRepository.save(bookmark);
                }
            }
        }
    }

    @Override
    public Bookmark deleteBookmark(BookmarkRequestDTO request) {
        Bookmark userBookmark = bookmarkRepository.findByUserIdAndTitle(request.getUserId(), request.getTitle());
        userBookmark.getBooks().remove(bookRepository.findById(request.getBookId()));
        return bookmarkRepository.save(userBookmark);
    }
}
