package org.echocat.kata.java.part1;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) throws IOException  {
        ReadCSVSortList rsl = new ReadCSVSortList();
        System.out.println("Books");
        rsl.readBooks();
        System.out.println("Magazines");
        rsl.readMagazines();
        System.out.println("Authors");
        rsl.readAuthors();
        rsl.sort();
        System.out.println("Search");
        rsl.search();
    }

}
