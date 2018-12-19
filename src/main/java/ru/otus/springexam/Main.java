package ru.otus.springexam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import ru.otus.springexam.domain.Person;
import ru.otus.springexam.domain.Question;
import ru.otus.springexam.service.ExamService;
import ru.otus.springexam.service.LoadTestService;
import ru.otus.springexam.service.PersonService;
import ru.otus.springexam.service.PrintPerson;

import java.util.Locale;

@PropertySource("classpath:application.properties")
@ComponentScan
public class Main {
    private static int numberOfQuestions;
    private static String pathToQuestionFile;
    //public static Locale LOCAL = Locale.forLanguageTag("en-US");
    public static Locale LOCAL = Locale.forLanguageTag("ru-RU");

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        PersonService service = context.getBean(PersonService.class);
        LoadTestService loadservice = context.getBean(LoadTestService.class);
        ExamService exam = context.getBean(ExamService.class);
        Person person = service.getByName("");
        Question question = loadservice.getByPath(pathToQuestionFile);
        person.setPercentCorrectAnswers(exam.start(question, numberOfQuestions));
        PrintPerson printPerson = context.getBean(PrintPerson.class);
        printPerson.print(person);
    }

    @Value("${number.questions}")
    private void setNumberOfQuestions(String s) { numberOfQuestions = Integer.parseInt(s); }

    @Value("${filename}")
    private void setPathToQuestionFile(String s) { pathToQuestionFile = s; }
}
