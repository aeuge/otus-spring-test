package ru.otus.springexam.dao;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.domain.Person;
import java.util.Scanner;
import static ru.otus.springexam.service.MainExamImpl.LOCAL;


public class PersonDaoKeyboard implements PersonDao {
    private int defaultAge;

    private MessageSource messageSource;

    public PersonDaoKeyboard(MessageSource messageSource, YamlProps props) {
        this.messageSource = messageSource;
        this.defaultAge = Integer.parseInt(props.getDefaultAge());
    }

    public Person findByName(String name) {
        System.out.println(messageSource.getMessage("enter.fam",new String[]{},LOCAL));
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        System.out.println(messageSource.getMessage("enter.name",new String[]{},LOCAL));
        answer += " " + scanner.nextLine();
        return new Person(answer, defaultAge);
    }
}
