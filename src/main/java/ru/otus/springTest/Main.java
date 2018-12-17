package ru.otus.springTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.springTest.domain.Person;
import ru.otus.springTest.service.PersonService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        PersonService service = context.getBean(PersonService.class);
        Person ivan = service.getByName("Ivan");
        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
    }
}
