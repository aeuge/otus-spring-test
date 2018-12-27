package ru.otus.springexam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.domain.Question;

@SpringBootTest
@EnableConfigurationProperties(YamlProps.class)
@TestPropertySource(locations= "classpath:application.yml")
@DisplayName("Запуск тестового сервиса по проведению экзамена")
class ExamMainImplTest {
    @Autowired
    MainExam mainExam;

    @Autowired
    YamlProps props;

    @Test
    @DisplayName("тестирование успешно закончилось")
    void start() {
        try {
            int numberOfQuestions = Integer.parseInt(props.getNumberOfQuestions());
            Question question = new Question();
            question.add("Сколько будет 2+2?","4");
            mainExam.startExam("Аристов Евгений", question, numberOfQuestions);
            String q = mainExam.getQuestion();
            String result = mainExam.setQuestion("4");
            Assertions.assertEquals(result,"Имя Аристов Евгений Возраст 28 Процент правильных ответов 100 ");
            Assertions.assertEquals(q,"Пожалуйста, ответьте на вопросы: Сколько будет 2+2?");
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("fail");
        }
    }
}