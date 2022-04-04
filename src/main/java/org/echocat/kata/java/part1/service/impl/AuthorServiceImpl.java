package org.echocat.kata.java.part1.service.impl;

import org.echocat.kata.java.part1.models.*;
import org.echocat.kata.java.part1.repository.UserRepository;
import org.echocat.kata.java.part1.repository.BookRepository;
import org.echocat.kata.java.part1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //---------------------Update------------------------------
    @Override
    public User update(User user, Long id) {
        User updateAuthor = userRepository.findById(id);
        updateAuthor.setFirstName(user.getFirstName());
        updateAuthor.setLastName(user.getLastName());
        updateAuthor.setEmail(user.getEmail());
        updateAuthor.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(updateAuthor);
    }

    //---------------------Save------------------------------
    @Override
    public User save(User user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        newUser.setRole(Role.USER);
        newUser.setStatus(Status.ACTIVE);
        return userRepository.save(newUser);
    }

    //---------------------Find------------------------------
    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //---------------------Exists------------------------------
    @Override
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    //---------------------Delete------------------------------
    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
