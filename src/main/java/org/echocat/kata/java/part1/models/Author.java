package org.echocat.kata.java.part1.models;

public class Author {
    String email,firstName,lastName;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
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