package ru.otus.springTest.dao;

import ru.otus.springTest.domain.Person;

import java.util.Scanner;

public class PersonDaoKeyboard implements PersonDao {
    private int defaultAge;

    public void setDefaultAge(String defaultAge) {
        this.defaultAge = Integer.decode(defaultAge);
    }

    public Person findByName(String name) {
        System.out.println("Введите пожалуйста Фамилию и Имя");
        Scanner scanner = new Scanner(System.in);
        return new Person(scanner.nextLine(), defaultAge);
    }
}
