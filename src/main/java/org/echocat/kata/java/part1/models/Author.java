package org.echocat.kata.java.part1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToMany()
    @JoinTable(
            name = "books_authors",
            joinColumns = @JoinColumn(name = "id_author"),
            inverseJoinColumns = @JoinColumn(name = "id_book")
    )
    @JsonIgnore
    private Set<Book> books = new HashSet<>();
    @ManyToMany()
    @JoinTable(
            name = "magazines_authors",
            joinColumns = @JoinColumn(name = "id_author"),
            inverseJoinColumns = @JoinColumn(name = "id_magazine")
    )
    @JsonIgnore
    private Set<Magazine> magazines = new HashSet<>();

    private String email;
    private String firstName;
    private String lastName;
    private Status status;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;

    public String toString() {
        return "\nEmail: "
                + getEmail()
                + "\nFirstName: "
                + getFirstName()
                + "\nLastName: "
                + getLastName();
    }
}