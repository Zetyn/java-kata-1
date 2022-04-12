package org.echocat.kata.java.part1.models;

import lombok.Data;

@Data
public class BookmarkRequestDTO {
    private Long userId;
    private Long bookId;
    private BookmarkEnum title;
}
