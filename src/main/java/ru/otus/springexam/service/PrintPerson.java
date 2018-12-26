package ru.otus.springexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springexam.domain.Person;
import static ru.otus.springexam.service.MainExamImpl.LOCAL;

@Service
public class PrintPerson {
    private MessageSource messageSource;

    public PrintPerson(MessageSource messageSource) { this.messageSource = messageSource; }

    public void print(Person person) {
        System.out.println(messageSource.getMessage("user.info", new String[] {person.getName(), String.valueOf(person.getAge()),  String.valueOf(person.getPercentCorrectAnswers())},LOCAL));
    }
}
