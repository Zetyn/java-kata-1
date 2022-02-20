package org.echocat.kata.java.part1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@RestController
@EntityScan("org.echocat.kata.java.part1.models")
@EnableJpaRepositories("org.echocat.kata.java.part1.repository")
@RequestMapping("/library")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
