package ru.otus.springexam.service;

import ru.otus.springexam.domain.Question;

public interface ExamService {

    long start(Question question, int numberOfQuestions);
}
