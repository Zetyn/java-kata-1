package org.echocat.kata.java.part1.repository;

import org.echocat.kata.java.part1.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    User findById(Long id);

    User findByEmail(String email);

    void deleteById(Long id);

    boolean existsById(Long id);
}
