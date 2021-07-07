package org.echocat.kata.java.part1;

import java.util.ArrayList;
import java.util.List;


public class SearchService {

    public TitleIsbnAuthorModel searchByIsbn(List<TitleIsbnAuthorModel> booksAndMagazines, String isbn) {
        TitleIsbnAuthorModel titleIsbnAuthorModel = new TitleIsbnAuthorModel() {};

        for (TitleIsbnAuthorModel value : booksAndMagazines) {
            if (value.getIsbn().equals(isbn)) {
                titleIsbnAuthorModel = value;
            }
        }
        return titleIsbnAuthorModel;
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
