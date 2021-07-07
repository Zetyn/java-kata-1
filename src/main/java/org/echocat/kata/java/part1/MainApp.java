package org.echocat.kata.java.part1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws IOException  {
        CsvReader reader = new CsvReader();

        List<Author> authors = reader.readAuthors();
        List<Book> books = reader.readBooks();
        List<Magazine> magazines = reader.readMagazines();
        List<TitleIsbnAuthorModel> booksAndMagazinesSort = new ArrayList<>();
        booksAndMagazinesSort.addAll(books);
        booksAndMagazinesSort.addAll(magazines);
        Sort.sortBooksAndMagazinesByTitle(booksAndMagazinesSort);

        ConsolePrinter printer = new ConsolePrinter();

        printer.print("\nSorted books and magazines\n" + booksAndMagazinesSort);
        printer.print("\nAuthors:\n" + authors);

        SearchService searchBookService = new SearchService();
        Scanner in = new Scanner(System.in);
        printer.print("\nEnter isbn to search\n");
        String isbn = in.nextLine();
        printer.print("\nEnter the author to search\n");
        String author = in.nextLine();

        TitleIsbnAuthorModel bookByIsbnResults = searchBookService.searchByIsbn(booksAndMagazinesSort,isbn);
        printer.print("\nFound by isbn\n"+ bookByIsbnResults);

        List<TitleIsbnAuthorModel> bookByAuthorResults = searchBookService.searchByAuthor(booksAndMagazinesSort,author);
        printer.print("\nFound by author\n" + bookByAuthorResults);

        in.close();

    }
}
