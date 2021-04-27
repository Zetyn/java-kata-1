package org.echocat.kata.java.part1;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReadCSV_SortList {

    List<getBooks> bookList = new ArrayList<>();
    List<getBooks> bookSort = new ArrayList<>(bookList);
    List<getMagazines> magazinesList = new ArrayList<>();
    List<getAuthors> authorsList = new ArrayList<>();

    public void readBooks() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader("Z:/java-kata-1-master/src/main/resources/org/echocat/kata/java/part1/data/books.csv"));
        
    String line = null;
    Scanner scanner = null;
    int index = 0;
    

    while ((line = reader.readLine())!= null) {
        getBooks gb = new getBooks();
        scanner = new Scanner(line);
        scanner.useDelimiter(";");
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
            } else {System.out.println("Некоректні дані " + data);}
            index++;
        }
        index = 0;
        bookList.add(gb);
    }
    reader.close();
    System.out.println(bookList);
    }

    public void readMagazines() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Z:/java-kata-1-master/src/main/resources/org/echocat/kata/java/part1/data/magazines.csv"));
            
        String line = null;
        Scanner scanner = null;
        int index = 0;
        
    
        while ((line = reader.readLine())!= null) {
            getMagazines gm = new getMagazines();
            scanner = new Scanner(line);
            scanner.useDelimiter(";");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if(index == 0) {
                    gm.setTitle(data);
                } else if (index == 1) {
                    gm.setIsbn(data);
                } else if (index == 2) {
                    gm.setAuthor(data);
                } else if(index == 3) {
                    gm.setPublishedAt(data);
                } else {System.out.println("Некоректні дані " + data);}
                index++;
            }
            index = 0;
            magazinesList.add(gm);
        }
        reader.close();
        System.out.println(magazinesList);
        }
        public void readAuthors() throws IOException{
            BufferedReader reader = new BufferedReader(new FileReader("Z:/java-kata-1-master/src/main/resources/org/echocat/kata/java/part1/data/authors.csv"));

            String line = null;
            Scanner scanner = null;
            int index = 0;
            

            while((line = reader.readLine())!=null) {
                getAuthors ga = new getAuthors();
                scanner = new Scanner(line);
                scanner.useDelimiter(";");
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
                authorsList.add(ga);
            }
            reader.close();
            System.out.println(authorsList);
        }
        
        public void search() {
            Scanner in = new Scanner(System.in);
            String search = in.nextLine();
            for(int i = 0;i<bookList.size();i++) {
                if(bookList.get(i).getIsbn().equals(search)) {
                    System.out.println("\ntitle: " + bookList.get(i).getTitle());
                    System.out.println("\nauthor" + bookList.get(i).getAuthor());
                    System.out.println("\nisbn: " + bookList.get(i).getIsbn());
                    System.out.println("\ndescription: " + bookList.get(i).getDescription());
                } 
            }
            for(int i = 0;i<magazinesList.size();i++) {
                if(magazinesList.get(i).getIsbn().equals(search)) {
                    System.out.println("\ntitle: " + magazinesList.get(i).getTitle());
                    System.out.println("\nauthor: " + magazinesList.get(i).getAuthor());
                    System.out.println("\nisbn: " + magazinesList.get(i).getIsbn());
                    System.out.println("\npublishedAt: " + magazinesList.get(i).getPublishedAt());
                } 
            }

            for (int i = 0;i<bookList.size();i++) {
                if (bookList.get(i).getAuthor().equals(search)) {
                    System.out.println("\ntitle: " + bookList.get(i).getTitle());
                    System.out.println("\nauthor: " + bookList.get(i).getAuthor());
                    System.out.println("\nisbn: " + bookList.get(i).getIsbn());
                    System.out.println("\ndescription: " + bookList.get(i).getDescription());
                }
            }
            for (int i = 0;i<magazinesList.size();i++) {
                if (magazinesList.get(i).getAuthor().equals(search)) {
                    System.out.println("\ntitle: " + magazinesList.get(i).getTitle());
                    System.out.println("\nauthor: " + magazinesList.get(i).getAuthor());
                    System.out.println("\nisbn: " + magazinesList.get(i).getIsbn());
                    System.out.println("\npublishedAt: " + magazinesList.get(i).getPublishedAt());
                }
            }
            in.close();
        }
        public void sort() {
            Comparator<getBooks> comparatorBooks = new Comparator<getBooks>(){
                @Override
                public int compare(getBooks o1, getBooks o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            };
            Comparator<getMagazines> comparatorMagazines = new Comparator<getMagazines>(){
                @Override
                public int compare(getMagazines o1, getMagazines o2) {
                    return o1.getTitle().compareTo(o2.getTitle());
                }
            };
            bookList.sort(comparatorBooks);
            magazinesList.sort(comparatorMagazines);
            System.out.println("\nSort by title books\n");
            System.out.println(bookList);
            System.out.println("\nSort by title magazines\n");
            System.out.println(magazinesList);
        }
}
