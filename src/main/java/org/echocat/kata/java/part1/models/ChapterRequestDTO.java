package org.echocat.kata.java.part1.models;

import lombok.Data;

@Data
public class ChapterRequestDTO {
    private int chapter;
    private int volume;
    private String name;
    private String file;
    private Long bookId;
    private Book book;
}
