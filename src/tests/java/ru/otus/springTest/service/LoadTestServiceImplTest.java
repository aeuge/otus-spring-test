package ru.otus.springTest.service;

import ru.otus.springTest.domain.Question;

import static org.junit.jupiter.api.Assertions.*;

class LoadTestServiceImplTest {

    @org.junit.jupiter.api.Test
    void getByPath() {
        LoadTestServiceImpl loadTestService = new LoadTestServiceImpl();
        Question question = loadTestService.getByPath("quest.scv");
        System.out.println(question);
    }
}