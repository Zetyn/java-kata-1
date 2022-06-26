package org.echocat.kata.java.part1.service.impl;

import org.echocat.kata.java.part1.models.Chapter;
import org.echocat.kata.java.part1.models.ChapterNameAndNumberDTO;
import org.echocat.kata.java.part1.models.ChapterRequestDTO;
import org.echocat.kata.java.part1.repository.ChapterRepository;
import org.echocat.kata.java.part1.service.BookService;
import org.echocat.kata.java.part1.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;
import java.util.Set;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository chapterRepository;

    @Autowired
    private BookService bookService;

    @Override
    @Transactional
    public Chapter findByBookIdAndChapterAndVolume(Long bookId, int chapter, int volume) {
        return chapterRepository.findByBook_IdAndChapterNumberAndVolumeNumber(bookId,chapter,volume);
    }

    @Override
    public Chapter countChaptersByBook_Id(Long bookId) {
        return chapterRepository.countChaptersByBook_Id(bookId);
    }

    @Override
    public Set<ChapterNameAndNumberDTO> findAllChaptersByBook_Id(Long bookId) {
        return chapterRepository.findAllByBook_Id(bookId);
    }

    @Override
    public Chapter save(ChapterRequestDTO requestDTO) throws IOException {
        LocalDate date = LocalDate.now();
        byte[] decodedBytes = Base64.getDecoder().decode(requestDTO.getFile());
        Chapter chapter = new Chapter(
                requestDTO.getName(),
                requestDTO.getChapter(),
                requestDTO.getVolume(),
                bookService.findById(requestDTO.getBookId()),
                decodedBytes);
        chapter.setDateAdded(date);
        return chapterRepository.save(chapter);
    }
}
