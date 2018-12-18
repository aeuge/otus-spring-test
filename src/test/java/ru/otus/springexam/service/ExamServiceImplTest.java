package ru.otus.springexam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.otus.springexam.domain.Question;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class ExamServiceImplTest {

    @Test
    void start() {
        try {
            Question question = new Question();
            question.add("Сколько будет 2+2?","4");
            ExamService exam = new ExamServiceImpl();
            ByteArrayInputStream in = new ByteArrayInputStream("4\n".getBytes());
            System.setIn(in);
            long result = exam.start(question,10);
            System.setIn(System.in);
            System.out.println("% правильных ответов " + result);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("fail");
        }
    }
}