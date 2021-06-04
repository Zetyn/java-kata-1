package main.java.org.echocat.kata.java.part1;

import java.util.ArrayList;
import java.util.List;

import org.echocat.kata.java.part1.Book;

public class SearchBookService {

    public Book searchByIsbn(List<Book> books,String isbn) {
        Book book = new Book();
        for(int i = 0;i<books.size();i++) {
            if(books.get(i).getIsbn().equals(isbn)) {
                for (int j = 0; j <= 3; j++) {
                    if (j == 0) {
                        book.setTitle(books.get(i).getTitle());
                    } else if (j == 1) {
                        book.setIsbn(books.get(i).getIsbn());
                    } else if (j == 2) {
                        book.setAuthor(books.get(i).getAuthor());
                    } else if (j == 3) {
                        book.setDescription(books.get(i).getDescription());
                    }
                }
            }
        }
        return book;
    }
    
    public List<Book> searchByAuthor(List<Book> books,String author) {
        List<Book> booksFound = new ArrayList<>();
        for (int i = 0;i<books.size();i++) {
            List<AuthorEmail> authors = books.get(i).getAuthor();
            String authorTemp = "";
            for (AuthorEmail temp : authors) {
                authorTemp = temp.toString();
                if (authorTemp.equals(author)) {
                    Book book = new Book();
                    for (int j = 0; j <= 3; j++) {
                        if (j == 0) {
                            book.setTitle(books.get(i).getTitle());
                        } else if (j == 1) {
                            book.setIsbn(books.get(i).getIsbn());
                        } else if (j == 2) {
                            book.setAuthor(books.get(i).getAuthor());
                        } else if (j == 3) {
                            book.setDescription(books.get(i).getDescription());
                        }
                    }
                    booksFound.add(book);
                }
            }
        }
        return booksFound;
    }

}
