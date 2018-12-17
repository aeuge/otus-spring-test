package ru.otus.springTest.service;

import ru.otus.springTest.domain.Question;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class LoadTestServiceImplTest {

    @Test
    void getByPath() {
        LoadTestServiceImpl loadTestService = new LoadTestServiceImpl();
        Question question = loadTestService.getByPath("quest.csv");
        System.out.println(question);
    }
}