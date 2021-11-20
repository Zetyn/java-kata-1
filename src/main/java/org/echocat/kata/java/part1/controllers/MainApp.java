package org.echocat.kata.java.part1.controllers;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication()
@RestController
@ComponentScan("org.echocat.kata.java.part1")
@EntityScan("org.echocat.kata.java.part1.models")
@EnableJpaRepositories("org.echocat.kata.java.part1.repository")
@RequestMapping("/library")
public class MainApp {
/*
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private MagazineService magazineService;


    //--------------------------------------------
    //Get book,magazine,author by id
    @GetMapping("/books/{id}")
    public Book bookDetails(@PathVariable("id") Long id) {
        if (bookService.existsById(id)) {
            return bookService.findById(id);
        }
        return null;
    }

    @GetMapping("/magazines/{id}")
    public Magazine magazineDetails(@PathVariable("id") Long id) {
        if (magazineService.existsById(id)) {
            return magazineService.findById(id);
        }
        return null;
    }

    @GetMapping("/authors/{id}")
    public Author authorDetails(@PathVariable("id") Long id) {
        if (authorService.existsById(id)) {
            return authorService.findById(id);
        }
        return null;
    }
    //-----------------------------------------
    //Get all books,magazines,authors
    @GetMapping("/books")
    public Iterable<Book> getBooks() {
        return bookService.findAll();
    }

    @GetMapping("/magazines")
    public Iterable<Magazine> getMagazines() {
        return magazineService.findAll();
    }

    @GetMapping("/authors")
    public Iterable<Author> getAuthors() {
        return authorService.findAll();
    }

*/


/*
    @GetMapping
    public void print() {
        Iterable<Book> books = bookRepository.findAll();
        printer.print("\nBooks");
        printer.print(books);
        Iterable<Author> authors = authorRepository.findAll();
        printer.print("\nAuthors");
        printer.print(authors);
        Iterable<Magazine> magazines = magazineRepository.findAll();
        printer.print("\nMagazines");
        printer.print(magazines);

        printer.print("------test-------");
    }
*/
/*
    @GetMapping("/")
    public void consolePrint() throws IOException {
        Iterable<Book> books = bookAndMagazineRepository.findAll();
        System.out.println(books);

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

        TitleIsbnAuthorModel bookByIsbnResults = searchBookService.searchByIsbn(booksAndMagazinesSort, isbn);
        printer.print("\nFound by isbn\n" + bookByIsbnResults);

        List<TitleIsbnAuthorModel> bookByAuthorResults = searchBookService.searchByAuthor(booksAndMagazinesSort, author);
        printer.print("\nFound by author\n" + bookByAuthorResults);

        in.close();

    }*/
}
