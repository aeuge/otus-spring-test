package ru.otus.springexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.otus.springexam.domain.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static ru.otus.springexam.Main.LOCAL;

@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private MessageSource messageSource;

    public long start(Question question, int numberOfQuestions) {
        int numberOfCorrectAnswers = 0;
        List<String> valuesList = new ArrayList<>(question.keys());
        Collections.shuffle(valuesList);

        int maxQuestions = numberOfQuestions > valuesList.size() ? valuesList.size() : numberOfQuestions;
        System.out.println(messageSource.getMessage("question",new String[]{},LOCAL));
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < maxQuestions; i++) {
            System.out.println(valuesList.get(i));
            String answer = scanner.nextLine();
            if (answer.equals(question.get(valuesList.get(i)))) {numberOfCorrectAnswers++; };
        }

        return numberOfCorrectAnswers*100/maxQuestions;
    }
}
