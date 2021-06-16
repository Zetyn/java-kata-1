package org.echocat.kata.java.part1;

import java.util.Comparator;
import java.util.List;

public class Sort extends TitleIsbnAuthor{

    public void sortBooksAndMagazinesByTitle(List<TitleIsbnAuthor> list) {
        Comparator<TitleIsbnAuthor> comparator = Comparator.comparing(TitleIsbnAuthor::getTitle);
        list.sort(comparator);
    }
}

