package org.echocat.kata.java.part1;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ReadOutput {

    List<Book> books = new ArrayList<>();
    List<Magazine> magazines = new ArrayList<>();
    List<Author> authors = new ArrayList<>();

    public void readBooks() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("Z:/java-kata-1-master/src/main/resources/org/echocat/kata/java/part1/data/books.csv"));
        
    String line = null;
    Scanner scanner = null;
    int index = 0;
    int k = 0;
    

    while ((line = reader.readLine())!= null) {
        Book gb = new Book();
        scanner = new Scanner(line);
        scanner.useDelimiter(";");
        if (k == 1) {
            while (scanner.hasNext()) {
                String data = scanner.next();
                if(index == 0) {
                    gb.setTitle(data);
                } else if (index == 1) {
                    gb.setIsbn(data);
                } else if (index == 2) {
                    gb.setAuthor(data);
                } else if(index == 3) {
                    gb.setDescription(data);
                } else {System.out.println("incorrect data " + data);}
                index++;
            }
            index = 0;
            books.add(gb);
        } else {k = 1;}

    }
    reader.close();
    }

    public void readMagazines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Z:/java-kata-1-master/src/main/resources/org/echocat/kata/java/part1/data/magazines.csv"));
            
        String line = null;
        Scanner scanner = null;
        int index = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy");
        int k = 0;

        while ((line = reader.readLine())!= null) {
            Magazine gm = new Magazine();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            if (k == 1) {
                while (scanner.hasNext()) {
                    String data = scanner.next();
                        if(index == 0) {
                            gm.setTitle(data);
                        } else if (index == 1) {
                            gm.setIsbn(data);
                        } else if (index == 2) {
                            gm.setAuthor(data);
                        } else if(index == 3) {
                            LocalDate date = LocalDate.parse(data, formatter);
                            gm.setPublishedAt(date);
                        }  else {System.out.println("Некоректні дані " + data);}
                        index++;
                    }
                    index = 0;
                    magazines.add(gm);
            } else {k = 1;}

        }
        reader.close();
        }

        public void readAuthors() throws IOException{
            BufferedReader reader = new BufferedReader(new FileReader("Z:/java-kata-1-master/src/main/resources/org/echocat/kata/java/part1/data/authors.csv"));

            String line = null;
            Scanner scanner = null;
            int index = 0;
            int k = 0;

            while((line = reader.readLine())!=null) {
                Author ga = new Author();
                scanner = new Scanner(line);
                scanner.useDelimiter(";");
                if (k == 1) {
                    while(scanner.hasNext()) {
                        String data = scanner.next();
                        if (index == 0) {
                            ga.setEmail(data);
                        } else if (index == 1) {
                            ga.setFirstName(data);
                        } else if (index == 2) {
                            ga.setLastName(data);
                        } else {System.out.println("Некоректні дані " + data);}
                        index++;
                    }
                    index = 0;
                    authors.add(ga);
                } else {k = 1;}
            }
            reader.close();
        }
        
        public void output() throws IOException {
            readBooks();
            readMagazines();
            readAuthors();
            //вивід списків
            System.out.println("\nBooks: \n" + books);
            System.out.println("\nMagazines: \n" + magazines);
            System.out.println("\nAuthors: \n" + authors);
            
            //вивід сортованих списків
            SortSearch sso = new SortSearch();
            sso.sortBooks(books);
            System.out.println("\nSort by title books\n");
            System.out.println(books);
            sso.sortMagazines(magazines);
            System.out.println("\nSort by title magazines\n");
            System.out.println(magazines);
            //пошук
            System.out.println("\nSearch");
            sso.search(books, magazines);
        }
}

