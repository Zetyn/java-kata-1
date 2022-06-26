package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Chapter;
import org.echocat.kata.java.part1.models.ChapterNameAndNumberDTO;
import org.echocat.kata.java.part1.models.ChapterRequestDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;

@Service
public interface ChapterService {
    Chapter findByBookIdAndChapterAndVolume(Long bookId, int chapter, int volume);
    Chapter countChaptersByBook_Id(Long bookId);
    Set<ChapterNameAndNumberDTO> findAllChaptersByBook_Id(Long bookId);
    Chapter save(ChapterRequestDTO requestDTO) throws IOException;
}
