package com.example.bookstore19;

import com.example.bookstore19.domain.Book;
import com.example.bookstore19.domain.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Bookstore19Application {

    public static void main(String[] args) {
        SpringApplication.run(Bookstore19Application.class, args);
    }

    @Bean
    public CommandLineRunner books(BookRepository repository) {
        return (args) -> {
            repository.save(new Book("kalevinketamiinit", "kalevi", "666", 1990, 20.50));
            repository.save(new Book("asdasd", "allah", "345", 1992, 20.51));
            repository.save(new Book("asd", "wollah", "123", 1991, 20.52));

        };
    }
}
