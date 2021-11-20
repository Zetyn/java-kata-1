package org.echocat.kata.java.part1.service.impl;

import org.echocat.kata.java.part1.models.*;
import org.echocat.kata.java.part1.repository.AuthorRepository;
import org.echocat.kata.java.part1.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Author addBookForAuthor(Author author,Book book) {
        author.getBooks().add(book);
        return author;
    }

    @Override
    public Author addMagazineForAuthor(Author author,Magazine magazine) {
        author.getMagazines().add(magazine);
        return author;
    }

    @Override
    public Author update(Author author,Long id) {
        Author updateAuthor = authorRepository.findById(id);
        updateAuthor.setFirstName(author.getFirstName());
        updateAuthor.setLastName(author.getLastName());
        updateAuthor.setEmail(author.getEmail());
        updateAuthor.setPassword(passwordEncoder.encode(author.getPassword()));
        return authorRepository.save(updateAuthor);
    }

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

    @Override
    public boolean existsById(Long id) {
        return authorRepository.existsById(id);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

}
