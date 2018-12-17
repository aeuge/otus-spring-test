package ru.otus.springTest.dao;

import ru.otus.springTest.domain.Person;

public interface PersonDao {

    Person findByName(String name);
}
