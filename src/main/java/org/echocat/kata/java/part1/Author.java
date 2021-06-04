package org.echocat.kata.java.part1;

import main.java.org.echocat.kata.java.part1.AuthorEmail;

public class Author extends AuthorEmail{
    String firstName,lastName;

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String toString() {
        return "\nEmail: " 
        + getEmail() 
        + "\nFirstName: " 
        + getFirstName() 
        + "\nLastName: " 
        + getLastName();
    }
}