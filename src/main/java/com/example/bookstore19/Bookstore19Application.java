package com.example.bookstore19;

import com.example.bookstore19.domain.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class Bookstore19Application {

    public static void main(String[] args) {
        SpringApplication.run(Bookstore19Application.class, args);
    }

    @Primary
    @Bean
    public CommandLineRunner books(BookRepository repository, CategoryRepository drepository, UserRepository userRepository) {
        return (args) -> {

            drepository.save(new Category("wasd"));
            drepository.save(new Category("wasdasd"));
            drepository.save(new Category("wasdasdasd"));

            repository.save(new Book("asdasdasd", "qwe", "666", 1990, 20.50, drepository.findByName("wasdasdasd").get(0)));
            repository.save(new Book("asdasd", "qweqwe", "345", 1992, 20.51, drepository.findByName("wasdasd").get(0)));
            repository.save(new Book("asd", "qweqweqwe", "123", 1991, 20.52, drepository.findByName("wasd").get(0)));

            // Create users:  admin/admin
            //                user/user

            User user1 =new User("user","$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6","USER");
            User user2 =new User("admin","$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","ADMIN");

            userRepository.save(user1);
            userRepository.save(user2);

        };
    }
}
