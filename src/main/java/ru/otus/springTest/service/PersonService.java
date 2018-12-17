package ru.otus.springTest.service;

import ru.otus.springTest.domain.Person;

public interface PersonService {

    Person getByName(String name);
}
