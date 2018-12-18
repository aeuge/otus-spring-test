package ru.otus.springexam.service;

import ru.otus.springexam.domain.Question;

public interface LoadTestService {
    Question getByPath(String path);
}
