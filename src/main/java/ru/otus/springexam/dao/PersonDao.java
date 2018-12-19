package ru.otus.springexam.dao;

import ru.otus.springexam.domain.Person;

public interface PersonDao {
    Person findByName(String name);
}
