package org.echocat.kata.java.part1;

import java.util.List;

import main.java.org.echocat.kata.java.part1.AuthorEmail;

public class TitleIsbnAuthor {
    private String title;
    private String isbn;
    private List<AuthorEmail> author;

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
    public List<AuthorEmail> getAuthor() {
        return author;
    }
    public void setAuthor(List<AuthorEmail> author) {
        this.author = author;
    }
}
