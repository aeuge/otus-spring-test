package ru.otus.springexam.service;

import ru.otus.springexam.domain.Question;
import org.junit.jupiter.api.*;
import ru.otus.springexam.service.LoadTestServiceImpl;

class LoadTestServiceImplTest {

    @Test
    void getByPath() {
        try {
            LoadTestServiceImpl loadTestService = new LoadTestServiceImpl();
            Question question = loadTestService.getByPath("quest.csv");
            System.out.println(question);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("fail");
        }
    }
}