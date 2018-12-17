package ru.otus.springTest.service;

import ru.otus.springTest.domain.Question;

public interface ExamService {

    long start(Question question, int numberOfQuestions);
}
