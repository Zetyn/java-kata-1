package org.echocat.kata.java.part1.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany()
    @JoinTable(
            name = "books_users",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_book")
    )
    @JsonIgnore
    @ToString.Exclude
    private Set<Book> books = new HashSet<>();
//    @ManyToMany()
//    @JoinTable(
//            name = "magazines_users",
//            joinColumns = @JoinColumn(name = "id_user"),
//            inverseJoinColumns = @JoinColumn(name = "id_magazine")
//    )
//    @JsonIgnore
//    @ToString.Exclude
//    private Set<Magazine> magazines = new HashSet<>();

    @OneToMany(mappedBy = "id")
    @ToString.Exclude
    private Set<Bookmark> bookmark;

    private String email;
    private String firstName;
    private String lastName;
    private Status status;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}