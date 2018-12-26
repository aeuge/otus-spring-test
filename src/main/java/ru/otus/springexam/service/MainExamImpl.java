package ru.otus.springexam.service;

import org.springframework.stereotype.Service;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.domain.Person;
import ru.otus.springexam.domain.Question;
import java.util.Locale;

@Service
public class MainExamImpl implements MainExam {
    private static int numberOfQuestions;
    private static String pathToQuestionFile;
    public static Locale LOCAL;
    private PersonService service;
    private LoadTestService loadservice;
    private ExamService examservice;
    private PrintPerson printPerson;

    public MainExamImpl(PersonService service, LoadTestService loadservice, ExamService examservice, PrintPerson printPerson, YamlProps props) {
        this.service = service;
        this.loadservice = loadservice;
        this.examservice = examservice;
        this.printPerson = printPerson;
        LOCAL = Locale.forLanguageTag(props.getLocaleset());
        numberOfQuestions = Integer.parseInt(props.getNumberOfQuestions());
        pathToQuestionFile = props.getFilename();
    }

    @Override
    public void startExam() {
        Person person = service.getByName("");
        Question question = loadservice.getByPath(pathToQuestionFile);
        person.setPercentCorrectAnswers(examservice.start(question, numberOfQuestions));
        printPerson.print(person);
    }
}
