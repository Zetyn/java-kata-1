package org.echocat.kata.java.part1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws IOException  {
        CsvReader reader = new CsvReader();

        List<Author> authors = reader.readAuthors();
        List<Book> books = reader.readBooks();
        List<Magazine> magazines = reader.readMagazines();
        
        ConsolePrinter printer = new ConsolePrinter();

        printer.print("\nBooks:\n" + books);
        printer.print("\nMagazines:\n" + magazines);
        printer.print("\nAuthors:\n" + authors);

        Sort sort = new Sort();
        sort.sortBooksByTitle(books);
        sort.sortMagazinesByTitle(magazines);
        printer.print("\nSorted books\n" + books);
        printer.print("\nSorted magazines\n" + magazines);

        SearchBookService searchBookService = new SearchBookService();
        SearchMagazineService searchMagazineService = new SearchMagazineService();
        Scanner in = new Scanner(System.in);
        printer.print("\nEnter isbn to search\n");
        String isbn = in.nextLine();
        printer.print("\nEnter the author to search\n");
        String author = in.nextLine();

        Book bookByIsbnResults = searchBookService.searchByIsbn(books,isbn);
        printer.print("\nFound book by isbn\n" + bookByIsbnResults);

        Magazine magazineByIsbnResults = searchMagazineService.searchByIsbn(magazines,isbn);
        printer.print("\nFound magazine by isbn\n" + magazineByIsbnResults);


        List<Book> bookByAuthorResults = searchBookService.searchByAuthor(books,author);
        printer.print("\nFound book by author\n" + bookByAuthorResults);

        List<Magazine> magazineByAuthorResults = searchMagazineService.searchByAuthor(magazines,author);
        printer.print("\nFound magazine by author\n" + magazineByAuthorResults);
        in.close();

    }
}
