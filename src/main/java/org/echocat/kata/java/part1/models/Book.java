package org.echocat.kata.java.part1.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    @ManyToMany()
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_author")
    )
    private Set<Author> authors = new HashSet<>();
    private String description;


    @Override
    public String toString() {
        return "\ntitle: "
                + getTitle()
                + "\nisbn: "
                + getIsbn()
                + "\nauthors: "
                + getAuthors()
                + "\ndescription: "
                + getDescription();
    }


}
