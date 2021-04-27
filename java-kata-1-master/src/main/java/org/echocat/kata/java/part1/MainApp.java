package org.echocat.kata.java.part1;

import java.io.IOException;

public class MainApp {

    public static void main(String[] args) throws IOException  {
        ReadCSV_SortList b = new ReadCSV_SortList();
        System.out.println("Books");
        b.readBooks();
        System.out.println("Magazines");
        b.readMagazines();
        System.out.println("Authors");
        b.readAuthors();
        b.sort();
        System.out.println("search");
        b.search();
    }
    protected static String getHelloWorldText() {
        return "Hello world!";
    }

}
