package ru.otus.springTest;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.springTest.domain.Person;
import ru.otus.springTest.domain.Question;
import ru.otus.springTest.service.ExamService;
import ru.otus.springTest.service.LoadTestService;
import ru.otus.springTest.service.PersonService;

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
