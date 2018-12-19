package ru.otus.springexam.service;

import org.springframework.stereotype.Service;
import ru.otus.springexam.dao.PersonDao;
import ru.otus.springexam.domain.Person;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao dao;

    public PersonServiceImpl(PersonDao dao) {
        this.dao = dao;
    }

    public Person getByName(String name) {
        return dao.findByName(name);
    }

    public void setDao(PersonDao dao) {
        this.dao = dao;
    }

}
