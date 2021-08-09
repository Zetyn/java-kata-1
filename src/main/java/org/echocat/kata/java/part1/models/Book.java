package org.echocat.kata.java.part1.models;


public class Book extends TitleIsbnAuthorModel {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString() {
        return "\ntitle: "
        + getTitle()
        + "\nisbn: "
        + getIsbn()
        + "\nauthor: "
        + getAuthor()
        + "\ndescription: "
        + getDescription();
    }

}
