package ru.otus.springexam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import ru.otus.springexam.domain.Question;

import java.io.ByteArrayInputStream;

@Configuration
@PropertySource("classpath:application.properties")
class ExamServiceImplTest {
    @Value("1")
    private int numberOfQuestions=1;

    @Test
    void start() {
        try {
            System.out.println(numberOfQuestions);
            Question question = new Question();
            question.add("Сколько будет 2+2?","4");
            ExamService exam = new ExamServiceImpl();
            ByteArrayInputStream in = new ByteArrayInputStream("4\n".getBytes());
            System.setIn(in);
            long result = exam.start(question,numberOfQuestions);
            System.setIn(System.in);
            System.out.println("% правильных ответов " + result);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("fail");
        }
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}