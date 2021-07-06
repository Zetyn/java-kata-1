package org.echocat.kata.java.part1;

import java.util.Comparator;
import java.util.List;

public final class Sort{

    public static void sortBooksAndMagazinesByTitle(List<TitleIsbnAuthorModel> list) {
        Comparator<TitleIsbnAuthorModel> comparator = Comparator.comparing(TitleIsbnAuthorModel::getTitle);
        list.sort(comparator);
    }
}

