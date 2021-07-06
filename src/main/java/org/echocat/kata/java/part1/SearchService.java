package org.echocat.kata.java.part1;

import java.util.ArrayList;
import java.util.List;


public class SearchService {

    public List<TitleIsbnAuthorModel> searchByIsbn(List<TitleIsbnAuthorModel> booksAndMagazines, String isbn) {
        List<TitleIsbnAuthorModel> booksAndMagazinesFound = new ArrayList<>();

        for (TitleIsbnAuthorModel value : booksAndMagazines) {
            if (value.getIsbn().equals(isbn)) {
                booksAndMagazinesFound.add(value);
            }
        }
        return booksAndMagazinesFound;
    }

    public List<TitleIsbnAuthorModel> searchByAuthor(List<TitleIsbnAuthorModel> booksAndMagazines,String author) {
        List<TitleIsbnAuthorModel> booksAndMagazinesFound = new ArrayList<>();

        for (TitleIsbnAuthorModel value : booksAndMagazines) {
            List<String> authors = value.getAuthor();
            for (String temp : authors) {
                if (temp.equals(author)) {
                    booksAndMagazinesFound.add(value);
                }
            }
        }
        return booksAndMagazinesFound;
    }

}
