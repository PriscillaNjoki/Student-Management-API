package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository ){
        return args -> {
                    Student priscilla = new Student(
                            "priscilla" ,
                            "priscilla.kinyanjui99@yahoo.com" ,
                            LocalDate.of(2000, JANUARY,5)

            );
            Student Brian = new Student(
                    "Brian" ,
                    "brian.quentin@yahoo.com" ,
                    LocalDate.of(1990, JANUARY,5));
            repository.saveAll(
                    List.of(priscilla, Brian)
            );
        };
    }
}
