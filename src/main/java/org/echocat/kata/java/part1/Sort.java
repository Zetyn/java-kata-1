package org.echocat.kata.java.part1;

import java.util.Comparator;
import java.util.List;

// для чого цей клас наслідує TitleIsbnAuthor ?
// я так розумію що це має бути допоміжний клас який вміє сортувати друковані видання(книги і журнали),
// якщо так то почитай https://stackoverflow.com/questions/25223553/how-can-i-create-an-utility-class
public class Sort extends TitleIsbnAuthor{

    public void sortBooksAndMagazinesByTitle(List<TitleIsbnAuthor> list) {
        Comparator<TitleIsbnAuthor> comparator = Comparator.comparing(TitleIsbnAuthor::getTitle);
        list.sort(comparator);
    }
}

