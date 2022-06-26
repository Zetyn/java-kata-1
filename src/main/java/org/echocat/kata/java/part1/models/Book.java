package org.echocat.kata.java.part1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Entity
@Table(name = "books")
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private String description;
    private LocalDate dateAdded;
    private LocalDate yearOfIssue;
    @ManyToMany()
    @JoinTable(name = "books_users",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    @ToString.Exclude
    private Set<User> users;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Image> images;
    @ManyToMany()
    @JoinTable(name = "books_genres",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_genre")
    )
    @ToString.Exclude
    private List<Genre> genres;
    @ManyToMany()
    @JoinTable(name = "books_bookmarks",
            joinColumns = @JoinColumn(name = "id_book"),
            inverseJoinColumns = @JoinColumn(name = "id_bookmark")
    )
    @ToString.Exclude
    @JsonIgnore
    private Set<Bookmark> bookmarks;
    @OneToMany(mappedBy = "id")
    @JsonIgnore
    @ToString.Exclude
    private Set<Chapter> chapters;
}
