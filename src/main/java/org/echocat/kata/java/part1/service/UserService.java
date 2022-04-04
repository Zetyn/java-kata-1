package org.echocat.kata.java.part1.service;

import org.echocat.kata.java.part1.models.User;

public interface UserService {
    User update(User user, Long id);

    User save(User user);

    Iterable<User> findAll();

    User findById(Long id);

    User findByEmail(String email);

    boolean existsById(Long id);

    void deleteById(Long id);
}
