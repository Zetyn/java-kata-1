package org.echocat.kata.java.part1;

public class getBooks {

    private String title,isbn,autors,description;
    
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
        return autors;
    }

    public void setAuthor(String autors) {
        this.autors = autors;
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
