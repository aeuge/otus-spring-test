package ru.otus.springexam.service;

import ru.otus.springexam.domain.Person;

public interface PersonService {

    Person getByName(String name);
}
