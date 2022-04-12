package org.echocat.kata.java.part1.service.impl;

import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.models.BookText;
import org.echocat.kata.java.part1.repository.BookTextRepository;
import org.echocat.kata.java.part1.service.BookTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Objects;

@Service
public class BookTextServiceImpl implements BookTextService {

    @Autowired
    private BookTextRepository bookTextRepository;

    @Override
    @Transactional
    public BookText findByBookIdAndChapterAndVolume(Long bookId,int chapter,int volume) {
        return bookTextRepository.findByBook_IdAndChapterNumberAndVolumeNumber(bookId,chapter,volume);
    }

    @Override
    public BookText save(MultipartFile file, int chapter, int volume, Book book) throws IOException {
        String name = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        BookText bookText = new BookText(name,file.getContentType(),chapter,volume,book,file.getBytes());
        return bookTextRepository.save(bookText);
    }
}
