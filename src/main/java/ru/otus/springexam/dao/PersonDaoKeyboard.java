package ru.otus.springexam.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.otus.springexam.domain.Person;

import java.util.Scanner;

@Service
public class PersonDaoKeyboard implements PersonDao {
    @Value("28")
    private int defaultAge;

    public void setDefaultAge(String defaultAge) {
        this.defaultAge = Integer.decode(defaultAge);
    }

    public Person findByName(String name) {
        System.out.println("Введите пожалуйста Фамилию");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println("Введите пожалуйста Имя");
        answer += " " + scanner.nextLine();
        return new Person(answer, defaultAge);
    }
}
