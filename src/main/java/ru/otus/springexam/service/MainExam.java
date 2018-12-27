package ru.otus.springexam.service;

import ru.otus.springexam.domain.Question;

public interface MainExam {
    void startExam(String name);
    String getQuestion();
    String setQuestion(String answer);
    void startExam(String name, Question question, int numberOfQuestions);
}
