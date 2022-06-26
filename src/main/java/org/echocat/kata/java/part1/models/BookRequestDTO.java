package org.echocat.kata.java.part1.models;

import lombok.Data;

import java.util.List;

@Data
public class BookRequestDTO {
    private Long id;
    private String title;
    private String isbn;
    private String description;
    private String imageNames;//at the moment I get one photo title with more to change the list
    private List<String> genres;
    private byte[] imgFile;
}
