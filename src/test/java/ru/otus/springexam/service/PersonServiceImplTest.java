package ru.otus.springexam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.springexam.dao.PersonDao;
import ru.otus.springexam.dao.PersonDaoSimple;
import ru.otus.springexam.domain.Person;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceImplTest {

    @Test
    void getByName() {
        try {
            PersonDao personDao = new PersonDaoSimple();
            PersonService personService = new PersonServiceImpl(personDao);
            ((PersonServiceImpl) personService).setDao(personDao);
            Person person = personService.getByName("Иван");
            System.out.println("Имя: " + person.getName() + " Возраст: " + person.getAge());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("fail");
        }
    }
}