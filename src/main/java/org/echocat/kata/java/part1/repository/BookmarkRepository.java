package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.models.Bookmark;
import org.echocat.kata.java.part1.models.BookmarkEnum;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends CrudRepository<Bookmark,Long> {
    Iterable<Bookmark> findByUserId(Long userId);
    Iterable<Bookmark> findByUserEmail(String userEmail);
    Bookmark findByUserIdAndTitle(Long userId, BookmarkEnum title);
}
