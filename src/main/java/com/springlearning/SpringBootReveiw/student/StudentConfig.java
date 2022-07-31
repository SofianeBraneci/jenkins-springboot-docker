package com.springlearning.SpringBootReveiw.student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {

                    Student m = new Student(
                            1L,
                            "Meriem",
                            "meriem@gmail.com",
                            LocalDate.of(1998, 12, 24)
                    );

            Student a = new Student(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(1988, 2, 24)
            );

            repository.saveAll(List.of(m, a));

        };
    }
}
