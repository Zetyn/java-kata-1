package org.echocat.kata.java.part1;

import org.echocat.kata.java.part1.models.Author;
import org.echocat.kata.java.part1.models.Book;
import org.echocat.kata.java.part1.models.Magazine;
import org.echocat.kata.java.part1.models.TitleIsbnAuthorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
@RequestMapping("/home")
public class MainApp {

    public static void main(String[] args) {
        SpringApplication.run(MainApp.class,args);
    }

    private final CsvReader csvReader;

    @Autowired
    public MainApp(CsvReader csvReader) {
        this.csvReader = csvReader;
    }

    @GetMapping()
    public String home(Model model) throws IOException {
        model.addAttribute("Book",csvReader.index());
        return "home";
    }

/*
    @GetMapping("/print")
    public void consolePrint() throws IOException {

        CsvReader reader = new CsvReader();

        List<Author> authors = reader.readAuthors();
        List <Book> books = reader.readBooks();
        List <Magazine> magazines = reader.readMagazines();
        List <TitleIsbnAuthorModel> booksAndMagazinesSort = new ArrayList<>();
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
*/
}
