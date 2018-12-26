package ru.otus.springexam.dao;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.domain.Person;

import java.util.Scanner;

import static ru.otus.springexam.service.MainExamImpl.LOCAL;

@Service
public class PersonDaoShell implements PersonDao {
    private int defaultAge;

    private MessageSource messageSource;

    public PersonDaoShell(MessageSource messageSource, YamlProps props) {
        this.messageSource = messageSource;
        this.defaultAge = Integer.parseInt(props.getDefaultAge());
    }

    public Person findByName(String name) {
        return new Person(name, defaultAge);
    }
}
