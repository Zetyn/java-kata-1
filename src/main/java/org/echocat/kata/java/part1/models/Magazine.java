package org.echocat.kata.java.part1.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "magazines")
@Getter
@Setter
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String isbn;

    @ManyToMany()
    @JoinTable(
            name = "magazines_authors",
            joinColumns = @JoinColumn(name = "id_magazine"),
            inverseJoinColumns = @JoinColumn(name = "id_author")
    )
    private Set<Author> authors = new HashSet<>();
    @JsonFormat(pattern = "d.MM.yyyy")
    private LocalDate publishedAt;

    @Override
    public String toString() {
        return "\ntitle: "
                + getTitle()
                + "\nisbn: "
                + getIsbn()
                + "\nautor: "
                + getAuthors()
                + "\npublishedAt: "
                + getPublishedAt();
    }

}