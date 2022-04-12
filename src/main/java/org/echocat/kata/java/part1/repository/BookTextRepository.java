package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.models.BookText;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookTextRepository extends CrudRepository<BookText,Long> {
    BookText findByBook_IdAndChapterNumberAndVolumeNumber(Long bookId,int chapter,int volume);
}
