package org.echocat.kata.java.part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class CsvReader {

    List<Book> books = new ArrayList<>();
    List<Magazine> magazines = new ArrayList<>();
    List<Author> authors = new ArrayList<>();
    List<String> emails = new ArrayList<>();


    public List<Book> readBooks() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/org/echocat/kata/java/part1/data/books.csv"));
        
    String line;
    int k = 0;

    while ((line = reader.readLine())!= null) {
        Book book = new Book();
        String[] strings = line.split(";");
        if (k == 1) {
            book.setTitle(strings[0]);
            book.setIsbn(strings[1]);
            String[] authorsArray = strings[2].split(",");
            emails = new ArrayList<>();
            for (String email : authorsArray) {
                emails.add(email);
            }
            book.setAuthor(emails);
            book.setDescription(strings[3]);
            books.add(book);
        } else {k = 1;}
    }
    reader.close();
    return books;
    }

    public List<Magazine> readMagazines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/org/echocat/kata/java/part1/data/magazines.csv"));
            
        String line;
        int k = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");

        while ((line = reader.readLine())!= null) {
            Magazine magazine = new Magazine();
            String[] strings = line.split(";");
            if (k == 1) {
                magazine.setTitle(strings[0]);
                magazine.setIsbn(strings[1]);
                String[] str = strings[2].split(",");
                emails = new ArrayList<>();
                for (String email : str) {
                    emails.add(email);
                }
                magazine.setAuthor(emails);
                LocalDate date = LocalDate.parse(strings[3], formatter);
                magazine.setPublishedAt(date);
                magazines.add(magazine);
            } else {k = 1;}

        }
        reader.close();
        return magazines;
        }

        public List<Author> readAuthors() throws IOException{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/org/echocat/kata/java/part1/data/authors.csv"));

            String line;
            int k = 0;

            while((line = reader.readLine())!=null) {
                Author author = new Author();
                String[] strings = line.split(";");
                if (k == 1) {
                    author.setEmail(strings[0]);
                    author.setFirstName(strings[1]);
                    author.setLastName(strings[2]);
                    authors.add(author);
                } else {k = 1;}
            }
            reader.close();
            return authors;
        }
}

