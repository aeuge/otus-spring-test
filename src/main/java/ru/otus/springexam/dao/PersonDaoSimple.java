package ru.otus.springexam.dao;

import ru.otus.springexam.domain.Person;

public class PersonDaoSimple implements PersonDao {
    public void setDefaultAge(String defaultAge) {
        this.defaultAge = Integer.decode(defaultAge);
    }

    private int defaultAge;

    public Person findByName(String name) {
        return new Person(name, defaultAge);
    }
}