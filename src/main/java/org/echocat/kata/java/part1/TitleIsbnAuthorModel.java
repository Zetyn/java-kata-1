package org.echocat.kata.java.part1;

import java.util.List;


public abstract class TitleIsbnAuthorModel {
    private String title;
    private String isbn;
    private List<String> author;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public List<String> getAuthor() {
        return author;
    }
    public void setAuthor(List<String> author) {
        this.author = author;
    }
}