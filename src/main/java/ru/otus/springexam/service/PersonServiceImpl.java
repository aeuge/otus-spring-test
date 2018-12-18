package ru.otus.springexam.service;

import ru.otus.springexam.dao.PersonDao;
import ru.otus.springexam.domain.Person;

public class PersonServiceImpl implements PersonService {

    public void setDao(PersonDao dao) {
        this.dao = dao;
    }

    private PersonDao dao;

    public PersonServiceImpl () {}

    public Person getByName(String name) {
        return dao.findByName(name);
    }
}
