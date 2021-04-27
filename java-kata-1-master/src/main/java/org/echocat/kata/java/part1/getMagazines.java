package org.echocat.kata.java.part1;


public class getMagazines {
    private String title,isbn,autor,publishedAt;

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
    public String getAuthor() {
        return autor;
    }
    public void setAuthor(String autor) {
        this.autor = autor;
    }
    public String getPublishedAt() {
        return publishedAt;
    }
    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
    
    @Override
    public String toString() {
        return "\ntitle: " + getTitle() + "\nisbn: " + getIsbn() + "\nautor: " + getAuthor() + "\npublishedAt: " + getPublishedAt();
    }
}
