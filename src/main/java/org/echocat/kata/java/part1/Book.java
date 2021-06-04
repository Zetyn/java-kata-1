package org.echocat.kata.java.part1;


public class Book extends TitleIsbnAuthor{

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
        + "\nautor: "
        + getAuthor()
        + "\ndescription: " 
        + getDescription();
    }

}
