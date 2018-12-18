package ru.otus.springexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.springexam.domain.Person;
import ru.otus.springexam.domain.Question;
import ru.otus.springexam.service.ExamService;
import ru.otus.springexam.service.LoadTestService;
import ru.otus.springexam.service.PersonService;

import java.util.Locale;

@PropertySource("classpath:application.properties")
@ComponentScan
public class Main {
    @Autowired
    private MessageSource messageSource;

    private static int numberOfQuestions;
    private static String pathToQuestionFile;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Main.class);
        PersonService service = context.getBean(PersonService.class);
        LoadTestService loadservice = context.getBean(LoadTestService.class);
        ExamService exam = context.getBean(ExamService.class);
        Person person = service.getByName("Ivan");
        Question question = loadservice.getByPath(pathToQuestionFile);
        person.setPercentCorrectAnswers(exam.start(question, numberOfQuestions));
        new Main().printPerson(person);

    }

    private void printPerson(Person person) {
        //System.out.println(messageSource.getMessage("user.info", new String[] {person.getName(), String.valueOf(person.getAge()),  String.valueOf(person.getPercentCorrectAnswers())},Locale.ENGLISH));
        System.out.println(messageSource.getMessage("user.name",new String[]{},Locale.ENGLISH));
        //System.out.println(person.getName());
    }

    @Value("${number.questions}")
    private void setNumberOfQuestions(String s) {
        numberOfQuestions = Integer.parseInt(s);
    }

    @Value("${filename}")
    private void setPathToQuestionFile(String s) { pathToQuestionFile = s; }


}
