package org.echocat.kata.java.part1;

import java.util.Comparator;
import java.util.List;

public class Sort extends TIA{

    public void sortBooksByTitle(List<Book> books) {
        Comparator<Book> comparatorBooks = new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        books.sort(comparatorBooks);
    }

    public void sortMagazinesByTitle(List<Magazine> magazines) {
        Comparator<Magazine> comparatorMagazines = new Comparator<Magazine>(){
            @Override
            public int compare(Magazine o1, Magazine o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        magazines.sort(comparatorMagazines);
    }
}
