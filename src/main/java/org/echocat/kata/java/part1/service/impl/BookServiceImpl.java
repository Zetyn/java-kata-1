package org.echocat.kata.java.part1.service.impl;

import org.echocat.kata.java.part1.models.*;
import org.echocat.kata.java.part1.repository.BookRepository;
import org.echocat.kata.java.part1.repository.GenreRepository;
import org.echocat.kata.java.part1.repository.ImageRepository;
import org.echocat.kata.java.part1.service.UserService;
import org.echocat.kata.java.part1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private ImageRepository imageRepository;


    @Override
    public Page<Book> getBookPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "title");
        return bookRepository.findAll(pageable);
    }

    //--------------------Find------------------------------
    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Set<Book> findByGenres(Set<Genre> genres) {
        for (Genre genre: genres) {
            return bookRepository.findByGenres(genre);
        }
        return null;
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Iterable<Book> findByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    @Override
    public Iterable<Book> findByGenresAndTitle(Set<Genre> genres, String title) {
        for (Genre genre: genres) {
            return bookRepository.findByGenresAndTitleContainingIgnoreCase(genre,title);
        }
        return null;
    }

    //-------------------Update------------------------------
//    @Override
//    public Book update(BookRequestDTO book, long id) {
//        Book updateBook = bookRepository.findById(id);
//        updateBook.setTitle(book.getTitle());
//        updateBook.setIsbn(book.getIsbn());
////        updateBook.getUsers().addAll(book.getUsers());
//        updateBook.setDescription(book.getDescription());
////        updateBook.getImages().addAll(book.getImages());
////        List<Genre> newGenres = new ArrayList<>();
////        for (Genre genre:book.getGenres()) {
////            newGenres.add(genreRepository.findByGenre(genre.getGenre()));
////        }
////        updateBook.setGenres(newGenres);
//        List<String> genres = book.getGenres();
//        List<Genre> newGenres = new ArrayList<>();
//        for (String genre:genres) {
//            newGenres.add(genreRepository.findByGenre(genre));
//        }
//        updateBook.setGenres(newGenres);
//        return bookRepository.save(updateBook);
//    }

    //--------------------Save------------------------------
    @Override
    @Transactional
    public Book save(BookRequestDTO bookRequestDTO, @AuthenticationPrincipal User user) {
        Book book;
        if (bookRequestDTO.getId() == null) {
            book = new Book();
            LocalDate date = LocalDate.now();
            book.setDateAdded(date);
        } else {
            book = bookRepository.findById(bookRequestDTO.getId());
            List<Image> bookImages = book.getImages();
            for (Image image:bookImages) {
                imageRepository.delete(image);
                File file = new File("Z:/java-kata-github/java-kata-frontend-clone/public/img/bookImages/" + image.getImageName());
                if (file.delete()) {
                    System.out.println("Z:/java-kata-github/java-kata-frontend-clone/public/img/bookImages/" + image.getImageName() + " file deleted");
                } else {
                    System.out.println("Z:/java-kata-github/java-kata-frontend-clone/public/img/bookImages/" + image.getImageName() + " file not found");
                }
            }
        }
        book.setTitle(bookRequestDTO.getTitle());
        book.setIsbn(bookRequestDTO.getIsbn());
        book.setDescription(bookRequestDTO.getDescription());
        List<String> genres = bookRequestDTO.getGenres();
        List<Genre> newGenres = new ArrayList<>();
        for (String genre:genres) {
            newGenres.add(genreRepository.findByGenre(genre));
        }
        book.setGenres(newGenres);
        List<Image> images = new ArrayList<>();
        if (bookRequestDTO.getImgFile() != null) {
//        for (String imageName:bookRequestDTO.getImageNames()) {
            Image img = new Image();
            img.setImageName(bookRequestDTO.getImageNames());
            img.setBook(book);
            images.add(img);
            try (FileOutputStream fos = new FileOutputStream("Z:/java-kata-github/java-kata-frontend-clone/public/img/bookImages/" + img.getImageName())) {
                fos.write(bookRequestDTO.getImgFile(), 0, bookRequestDTO.getImgFile().length);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
//        }
        book.setImages(images);
        org.echocat.kata.java.part1.models.User u = userService.findByEmail(user.getUsername());
        if (book.getUsers() != null) {
            book.getUsers().add(u);
        } else {
            Set<org.echocat.kata.java.part1.models.User> users = new HashSet<>();
            users.add(u);
            book.setUsers(users);
        }
//        newBook.getUsers()
//                .addAll(book
//                        .getUsers()
//                        .stream()
//                        .map(a -> {
//                            User aa = userService.findByEmail(a.getEmail());
//                            aa.getBooks().add(newBook);
//                            return aa;
//                        }).collect(Collectors.toSet()));
//        List<Book> tmpBook = (List<Book>) bookRepository.findByTitleContainingIgnoreCase(book.getTitle());
//        img.setBook(tmpBook.get(0));
//        imageRepository.save(img);
        return bookRepository.save(book);
    }

    //--------------------Exists------------------------------
    @Override
    public boolean existsById(Long id) {
        return bookRepository.existsById(id);
    }

    //--------------------Delete------------------------------
    @Transactional
    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
