package org.echocat.kata.java.part1;

import java.util.ArrayList;
import java.util.List;



public class SearchMagazineService {

    public Magazine searchByIsbn(List<Magazine> magazines, String isbn) {
        Magazine magazine = new Magazine();
        for (int i = 0;i < magazines.size();i++) {
            if (magazines.get(i).getIsbn().equals(isbn)) {
                // що тут ти намагаєшся зробити?
                // чому не просто return magazine ?
                for (int j = 0; j <= 3; j++) {
                    if (j == 0) {
                        magazine.setTitle(magazines.get(i).getTitle());
                    } else if (j == 1) {
                        magazine.setIsbn(magazines.get(i).getIsbn());
                    } else if (j == 2) {
                        magazine.setAuthor(magazines.get(i).getAuthor());
                    } else if (j == 3) {
                        magazine.setPublishedAt(magazines.get(i).getPublishedAt());
                    }
                }
            }
        }
        return magazine;
    }
    public List<Magazine> searchByAuthor(List<Magazine> magazines,String author) {
        List<Magazine> magazineFound = new ArrayList<>();
        for (int i = 0;i<magazines.size();i++) {
            List<String> authors = magazines.get(i).getAuthor();
            String authorTemp = "";
            for (String temp : authors) {
                authorTemp = temp.toString();
                if (authorTemp.equals(author)) {
                    Magazine magazine = new Magazine();
                    // що тут ти намагаєшся зробити?
                    // чому не просто return magazine ?
                    for (int j = 0; j <= 3; j++) {
                        if (j == 0) {
                            magazine.setTitle(magazines.get(i).getTitle());
                        } else if (j == 1) {
                            magazine.setIsbn(magazines.get(i).getIsbn());
                        } else if (j == 2) {
                            magazine.setAuthor(magazines.get(i).getAuthor());
                        } else if (j == 3) {
                            magazine.setPublishedAt(magazines.get(i).getPublishedAt());
                        }
                    }
                    magazineFound.add(magazine);
                }
            }
        }
        return magazineFound;
    }

}
