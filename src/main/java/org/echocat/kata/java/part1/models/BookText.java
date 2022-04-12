package org.echocat.kata.java.part1.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "book_text")
public class BookText {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    private int chapterNumber;
    private int volumeNumber;
    @Lob
    private byte[] text;
    @ManyToOne()
    @JoinColumn(name = "book_id")
    private Book book;

    public BookText() {
    }

    public BookText(String name,String type,int chapterNumber,int volumeNumber,Book book,byte[] text) {
        this.name = name;
        this.type = type;
        this.chapterNumber = chapterNumber;
        this.volumeNumber = volumeNumber;
        this.book = book;
        this.text = text;
    }
}
