package ru.otus.springexam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.TestPropertySource;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.domain.Question;

import java.io.ByteArrayInputStream;

@SpringBootTest
@EnableConfigurationProperties(YamlProps.class)
@TestPropertySource(locations= "classpath:application.yml")
@DisplayName("Запуск тестового сервиса по проведению экзамена")
class ExamServiceImplTest {
    @Autowired
    ExamService examService;

    @Autowired
    YamlProps props;

    @MockBean
    CommandLineRunner commandLineRunner;

    @Test
    @DisplayName("тестирование успешно закончилось")
    void start() {
        try {
            Integer numberOfQuestions = Integer.parseInt(props.getNumberOfQuestions());
            Question question = new Question();
            question.add("Сколько будет 2+2?","4");

            ByteArrayInputStream in = new ByteArrayInputStream("4\n".getBytes());
            System.setIn(in);
            long result = examService.start(question,numberOfQuestions);
            System.setIn(System.in);
            Assertions.assertEquals(result,(long) 100);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("fail");
        }
    }
}