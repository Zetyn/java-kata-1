package org.echocat.kata.java.part1;


public class Magazine {
    private String title,isbn,author,publishedAt;

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
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
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
