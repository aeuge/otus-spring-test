package ru.otus.springTest.service;

import ru.otus.springTest.domain.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ExamServiceImpl implements ExamService {
    public long start(Question question, int numberOfQuestions) {
        int numberOfCorrectAnswers = 0;
        List<String> valuesList = new ArrayList<>(question.keys());
        Collections.shuffle(valuesList);

        int maxQuestions = numberOfQuestions > valuesList.size() ? valuesList.size() : numberOfQuestions;
        System.out.println("Пожалуйста, ответьте на вопросы:");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < maxQuestions; i++) {
            System.out.println(valuesList.get(i));
            String answer = scanner.nextLine();
            if (answer.equals(question.get(valuesList.get(i)))) {numberOfCorrectAnswers++; };
        }

        return numberOfCorrectAnswers*100/maxQuestions;
    }
}
