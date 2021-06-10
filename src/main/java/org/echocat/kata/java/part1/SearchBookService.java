package org.echocat.kata.java.part1;

import java.util.ArrayList;
import java.util.List;


public class SearchBookService {

    public Book searchByIsbn(List<Book> books,String isbn) {
        Book book = new Book();
        for (Book value : books) {
            if (value.getIsbn().equals(isbn)) {
                for (int j = 0; j <= 3; j++) {
                    if (j == 0) {
                        book.setTitle(value.getTitle());
                    } else if (j == 1) {
                        book.setIsbn(value.getIsbn());
                    } else if (j == 2) {
                        book.setAuthor(value.getAuthor());
                    } else if (j == 3) {
                        book.setDescription(value.getDescription());
                    }
                }
            }
        }
        return book;
    }
    
    public List<Book> searchByAuthor(List<Book> books,String author) {
        List<Book> booksFound = new ArrayList<>();
        for (Book value : books) {
            List<String> authors = value.getAuthor();
            String authorTemp = "";
            for (String temp : authors) {
                authorTemp = temp;
                if (authorTemp.equals(author)) {
                    Book book = new Book();
                    for (int j = 0; j <= 3; j++) {
                        if (j == 0) {
                            book.setTitle(value.getTitle());
                        } else if (j == 1) {
                            book.setIsbn(value.getIsbn());
                        } else if (j == 2) {
                            book.setAuthor(value.getAuthor());
                        } else if (j == 3) {
                            book.setDescription(value.getDescription());
                        }
                    }
                    booksFound.add(book);
                }
            }
        }
        return booksFound;
    }

}
