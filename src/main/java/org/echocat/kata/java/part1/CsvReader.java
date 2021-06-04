package org.echocat.kata.java.part1;

import java.util.Scanner;

import main.java.org.echocat.kata.java.part1.AuthorEmail;

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
    List<AuthorEmail> emails = new ArrayList<>();


    public List<Book> readBooks() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("Z:/java-kata-1-master/src/main/resources/org/echocat/kata/java/part1/data/books.csv"));
        
    String line = null;
    Scanner scanner = null;
    int index = 0;
    int k = 0;
    

    while ((line = reader.readLine())!= null) {
        Book book = new Book();
        AuthorEmail email = new AuthorEmail();
        scanner = new Scanner(line);
        scanner.useDelimiter(";");
        if (k == 1) {
            while (scanner.hasNext()) {
                String data = scanner.next();
                if(index == 0) {
                    book.setTitle(data);
                } else if (index == 1) {
                    book.setIsbn(data);
                } else if (index == 2) {
                    String[] str = data.split(",");
                    emails = new ArrayList<>();
                    for (int j = 0;j < str.length;j++) {
                        email = new AuthorEmail();
                        email.setEmail(str[j]);
                        emails.add(email);
                    }
                    book.setAuthor(emails);
                } else if(index == 3) {
                    book.setDescription(data);
                } else {System.out.println("incorrect data " + data);}
                index++;
            }
            index = 0;
            books.add(book);
        } else {k = 1;}
    }
    reader.close();
    return books;
    }

    public List<Magazine> readMagazines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Z:/java-kata-1-master/src/main/resources/org/echocat/kata/java/part1/data/magazines.csv"));
            
        String line = null;
        Scanner scanner = null;
        int index = 0;
        int k = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");

        while ((line = reader.readLine())!= null) {
            Magazine magazine = new Magazine();
            AuthorEmail email = new AuthorEmail();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            if (k == 1) {
                while (scanner.hasNext()) {
                    String data = scanner.next();
                        if(index == 0) {
                            magazine.setTitle(data);
                        } else if (index == 1) {
                            magazine.setIsbn(data);
                        } else if (index == 2) {
                            String[] str = data.split(",");
                            emails = new ArrayList<>();
                            for (int j = 0;j < str.length;j++) {
                                email = new AuthorEmail();
                                email.setEmail(str[j]);
                                emails.add(email);
                            }
                            magazine.setAuthor(emails);
                        } else if(index == 3) {
                            LocalDate date = LocalDate.parse(data, formatter);
                            magazine.setPublishedAt(date);
                        }  else {System.out.println("Некоректні дані " + data);}
                        index++;
                    }
                    index = 0;
                    magazines.add(magazine);
            } else {k = 1;}

        }
        reader.close();
        return magazines;
        }

        public List<Author> readAuthors() throws IOException{
            BufferedReader reader = new BufferedReader(new FileReader("Z:/java-kata-1-master/src/main/resources/org/echocat/kata/java/part1/data/authors.csv"));

            String line = null;
            Scanner scanner = null;
            int index = 0;
            int k = 0;

            while((line = reader.readLine())!=null) {
                Author author = new Author();
                scanner = new Scanner(line);
                scanner.useDelimiter(";");
                if (k == 1) {
                    while(scanner.hasNext()) {
                        String data = scanner.next();
                        if (index == 0) {
                            author.setEmail(data);
                        } else if (index == 1) {
                            author.setFirstName(data);
                        } else if (index == 2) {
                            author.setLastName(data);
                        } else {System.out.println("Некоректні дані " + data);}
                        index++;
                    }
                    index = 0;
                    authors.add(author);
                } else {k = 1;}
            }
            reader.close();
            return authors;
        }
}

