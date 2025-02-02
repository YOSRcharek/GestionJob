package com.example.gestionjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionJobApplication.class, args);
    }
    @Autowired
    private JobRepo repository;
    @Bean
    ApplicationRunner init() {
        return (args) -> {
// save
            repository.save(new Job("Service1", Boolean.TRUE));
            repository.save(new Job("Service2", Boolean.FALSE));
            repository.save(new Job("Service3", Boolean.FALSE));
            repository.save(new Job("Service4", Boolean.TRUE));

// fetch
            repository.findAll().forEach(System.out::println);


        };
}
}
