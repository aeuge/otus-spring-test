package ru.otus.springTest.service;

import ru.otus.springTest.dao.PersonDao;
import ru.otus.springTest.domain.Person;

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
