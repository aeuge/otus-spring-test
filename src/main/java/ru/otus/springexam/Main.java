package ru.otus.springexam;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.service.*;

@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context) {
        return args -> {
            MainExam mainExam = context.getBean(MainExamImpl.class);
            mainExam.startExam();
        };
    }
}
