package ru.otus.springTest.service;

import ru.otus.springTest.domain.Question;

import java.util.Map;

public interface LoadTestService {
    Question getByPath(String path);
}
