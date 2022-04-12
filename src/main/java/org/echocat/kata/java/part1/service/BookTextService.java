package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.models.BookText;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface BookTextService {
    BookText findByBookIdAndChapterAndVolume(Long bookId,int chapter,int volume);
    BookText save(MultipartFile file, int chapter, int volume, Book book) throws IOException;
}
