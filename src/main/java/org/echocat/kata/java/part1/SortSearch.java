package org.echocat.kata.java.part1;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class SortSearch{

    public void sortBooks(List<Book> books) {
        Comparator<Book> comparatorBooks = new Comparator<Book>(){
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        books.sort(comparatorBooks);
    }

    public void sortMagazines(List<Magazine> magazines) {
        Comparator<Magazine> comparatorMagazines = new Comparator<Magazine>(){
            @Override
            public int compare(Magazine o1, Magazine o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        magazines.sort(comparatorMagazines);
    }
    
    private String search;
    public void searchBooks(List<Book> books) {
        for(int i = 0;i<books.size();i++) {
            if(books.get(i).getIsbn().equals(search)) {
                System.out.println("\ntitle: " + books.get(i).getTitle());
                System.out.println("\nauthor" + books.get(i).getAuthor());
                System.out.println("\nisbn: " + books.get(i).getIsbn());
                System.out.println("\ndescription: " + books.get(i).getDescription());
            } 
        }

        for (int i = 0;i<books.size();i++) {
            if (books.get(i).getAuthor().equals(search)) {
                System.out.println("\ntitle: " + books.get(i).getTitle());
                System.out.println("\nauthor: " + books.get(i).getAuthor());
                System.out.println("\nisbn: " + books.get(i).getIsbn());
                System.out.println("\ndescription: " + books.get(i).getDescription());
            }
        }

    }
    public void searchMagazines(List<Magazine> magazines) {
        for(int i = 0;i<magazines.size();i++) {
            if(magazines.get(i).getIsbn().equals(search)) {
                System.out.println("\ntitle: " + magazines.get(i).getTitle());
                System.out.println("\nauthor: " + magazines.get(i).getAuthor());
                System.out.println("\nisbn: " + magazines.get(i).getIsbn());
                System.out.println("\npublishedAt: " + magazines.get(i).getPublishedAt());
            } 
        }

        for (int i = 0;i<magazines.size();i++) {
            if (magazines.get(i).getAuthor().equals(search)) {
                System.out.println("\ntitle: " + magazines.get(i).getTitle());
                System.out.println("\nauthor: " + magazines.get(i).getAuthor());
                System.out.println("\nisbn: " + magazines.get(i).getIsbn());
                System.out.println("\npublishedAt: " + magazines.get(i).getPublishedAt());

            }
        }

    }

    public void search(List<Book> books,List<Magazine> magazines) {
        Scanner in = new Scanner(System.in);
        search = in.nextLine();
        searchBooks(books);
        searchMagazines(magazines);
        in.close();
    }
}
