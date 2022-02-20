package org.echocat.kata.java.part1.service.impl;

import org.echocat.kata.java.part1.models.*;
import org.echocat.kata.java.part1.repository.AuthorRepository;
import org.echocat.kata.java.part1.repository.BookRepository;
import org.echocat.kata.java.part1.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //---------------------Update------------------------------
    @Override
    public Author update(Author author, Long id) {
        Author updateAuthor = authorRepository.findById(id);
        updateAuthor.setFirstName(author.getFirstName());
        updateAuthor.setLastName(author.getLastName());
        updateAuthor.setEmail(author.getEmail());
        updateAuthor.setPassword(passwordEncoder.encode(author.getPassword()));
        return authorRepository.save(updateAuthor);
    }

    //---------------------Save------------------------------
    @Override
    public Author save(Author author) {
        Author newAuthor = new Author();
        newAuthor.setId(author.getId());
        newAuthor.setFirstName(author.getFirstName());
        newAuthor.setLastName(author.getLastName());
        newAuthor.setEmail(author.getEmail());
        newAuthor.setPassword(passwordEncoder.encode(author.getPassword()));
        newAuthor.setRole(Role.USER);
        newAuthor.setStatus(Status.ACTIVE);
        return authorRepository.save(newAuthor);
    }

    //---------------------Find------------------------------
    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Author findByEmail(String email) {
        return authorRepository.findByEmail(email);
    }

    //---------------------Exists------------------------------
    @Override
    public boolean existsById(Long id) {
        return authorRepository.existsById(id);
    }

    //---------------------Delete------------------------------
    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

}
