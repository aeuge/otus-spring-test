package ru.otus.springexam.dao;

import ru.otus.springexam.domain.Person;

import java.util.Scanner;

public class PersonDaoKeyboard implements PersonDao {
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
