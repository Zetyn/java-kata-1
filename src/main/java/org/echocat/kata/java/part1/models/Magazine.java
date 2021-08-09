package org.echocat.kata.java.part1.models;

import java.time.LocalDate;

public class Magazine extends TitleIsbnAuthorModel {
    
    private LocalDate publishedAt;

    public LocalDate getPublishedAt() {
        return publishedAt;
    }
    public void setPublishedAt(LocalDate publishedAt) {
        this.publishedAt = publishedAt;
    }
    
    @Override
    public String toString() {
        return "\ntitle: " 
        + getTitle() 
        + "\nisbn: " 
        + getIsbn() 
        + "\nautor: " 
        + getAuthor() 
        + "\npublishedAt: " 
        + getPublishedAt();
    }
    
}
