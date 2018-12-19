package ru.otus.springexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springexam.domain.Person;
import static ru.otus.springexam.Main.LOCAL;

@Service
public class PrintPerson {
    @Autowired
    private MessageSource messageSource;

    public void print(Person person) {
        System.out.println(messageSource.getMessage("user.info", new String[] {person.getName(), String.valueOf(person.getAge()),  String.valueOf(person.getPercentCorrectAnswers())},LOCAL));
        //System.out.println(messageSource.getMessage("user.name",new String[]{},Locale.forLanguageTag("ru_RU")));
    }
}
