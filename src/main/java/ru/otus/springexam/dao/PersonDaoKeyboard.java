package ru.otus.springexam.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springexam.domain.Person;
import java.util.Scanner;
import static ru.otus.springexam.Main.LOCAL;

@Service
public class PersonDaoKeyboard implements PersonDao {
    @Value("${default.age}")
    private int defaultAge;

    @Autowired
    private MessageSource messageSource;

    public void setDefaultAge(String defaultAge) {
        this.defaultAge = Integer.decode(defaultAge);
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
