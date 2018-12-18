package ru.otus.springexam;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.springexam.domain.Person;
import ru.otus.springexam.domain.Question;
import ru.otus.springexam.service.ExamService;
import ru.otus.springexam.service.LoadTestService;
import ru.otus.springexam.service.PersonService;

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");
        PersonService service = context.getBean(PersonService.class);
        LoadTestService loadservice = context.getBean(LoadTestService.class);
        ExamService exam = context.getBean(ExamService.class);
        Person person = service.getByName("Ivan");
        Question question = loadservice.getByPath("quest.csv");
        person.setPercentCorrectAnswers(exam.start(question, 5));
        System.out.println("name: " + person.getName() + " age: " + person.getAge() + " percent of correct answers: " + person.getPercentCorrectAnswers() + "%");
    }
}
