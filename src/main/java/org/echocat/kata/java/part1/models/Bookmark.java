package org.echocat.kata.java.part1.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bookmarks")
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BookmarkEnum title;

    @ManyToMany()
    @JoinTable(name = "books_bookmarks",
            joinColumns = @JoinColumn(name = "id_bookmark"),
            inverseJoinColumns = @JoinColumn(name = "id_book")
    )
    @ToString.Exclude
    private Set<Book> books;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
