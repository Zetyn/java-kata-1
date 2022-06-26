package org.echocat.kata.java.part1.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.type.BlobType;

import javax.persistence.*;
import java.io.File;
import java.sql.Blob;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private int chapterNumber;
    private int volumeNumber;
    private LocalDate dateAdded;
    @Lob
    private byte[] text;
    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    public Chapter() {
    }

    public Chapter(String name, int chapterNumber, int volumeNumber, Book book, byte[] text) {
        this.name = name;
//        this.type = type;
        this.chapterNumber = chapterNumber;
        this.volumeNumber = volumeNumber;
        this.book = book;
        this.text = text;
    }
}
