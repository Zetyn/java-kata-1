package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.models.Chapter;
import org.echocat.kata.java.part1.models.ChapterNameAndNumberDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ChapterRepository extends CrudRepository<Chapter,Long> {
    Chapter findByBook_IdAndChapterNumberAndVolumeNumber(Long bookId, int chapter, int volume);
    Chapter countChaptersByBook_Id(Long bookId);
    Set<ChapterNameAndNumberDTO> findAllByBook_Id(Long bookId);
}
