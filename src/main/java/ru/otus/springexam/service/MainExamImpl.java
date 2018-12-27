package ru.otus.springexam.service;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.domain.Person;
import ru.otus.springexam.domain.Question;

import java.util.*;

@Service
public class MainExamImpl implements MainExam {
    private static int numberOfQuestions;
    private static String pathToQuestionFile;
    public static Locale LOCAL;
    private PersonService service;
    private LoadTestService loadservice;
    private MessageSource messageSource;
    private Person person;
    private int numberOfCorrectAnswers = 0;
    private Question question;
    private List<String> valuesList;
    private int currentQuestion=0;
    private int maxQuestions=0;

    public MainExamImpl(PersonService service, LoadTestService loadservice, YamlProps props, MessageSource messageSourse) {
        this.service = service;
        this.loadservice = loadservice;
        LOCAL = Locale.forLanguageTag(props.getLocaleset());
        numberOfQuestions = Integer.parseInt(props.getNumberOfQuestions());
        pathToQuestionFile = props.getFilename();
        this.messageSource = messageSourse;
    }

    @Override
    public void startExam(String name) {
        person = service.getByName(name);
        question = loadservice.getByPath(pathToQuestionFile);
        valuesList = new ArrayList<>(question.keys());
        Collections.shuffle(valuesList);
        maxQuestions = numberOfQuestions > valuesList.size() ? valuesList.size() : numberOfQuestions;
    }

    public void startExam(String name, Question question, int numberOfQuestions) {
        person = service.getByName(name);
        this.question = question;
        valuesList = new ArrayList<>(question.keys());
        maxQuestions = numberOfQuestions > valuesList.size() ? valuesList.size() : numberOfQuestions;
    }

    public String getQuestion() {
        return messageSource.getMessage("question",new String[]{valuesList.get(currentQuestion++)},LOCAL);
    }
    public String setQuestion(String answer) {
        if (answer.equals(question.get(valuesList.get(currentQuestion - 1)))) {numberOfCorrectAnswers++; };
        if (currentQuestion == maxQuestions)
            return getNumberOfCorrectAnswers();
        else
            return getQuestion();
    }

    public String getNumberOfCorrectAnswers() { ;
        person.setPercentCorrectAnswers(numberOfCorrectAnswers * 100 / maxQuestions);
        return messageSource.getMessage("user.info", new String[] {person.getName(), String.valueOf(person.getAge()),  String.valueOf(person.getPercentCorrectAnswers())}, LOCAL);
    }
}
