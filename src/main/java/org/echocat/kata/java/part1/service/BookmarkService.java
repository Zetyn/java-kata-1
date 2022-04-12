package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Bookmark;
import org.echocat.kata.java.part1.models.BookmarkEnum;
import org.echocat.kata.java.part1.models.BookmarkRequestDTO;
import org.springframework.stereotype.Service;

@Service
public interface BookmarkService {
    Iterable<Bookmark> findByUserId(Long userId);
    Bookmark findByUserIdAndTitle(Long userId,BookmarkEnum title);
    BookmarkEnum findByUserEmailAndBook(String userEmail, Long bookId);

    Bookmark saveBookmark(BookmarkRequestDTO request);
    Bookmark deleteBookmark(BookmarkRequestDTO request);
}
