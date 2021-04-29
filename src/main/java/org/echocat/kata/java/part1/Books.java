package org.echocat.kata.java.part1;

public class Books {

    private String title,isbn,author,description;
    
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
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "\ntitle: " + getTitle() + "\nisbn: " + getIsbn() + "\nautor: " + getAuthor() + "\ndescription: " + getDescription();
    }

}
