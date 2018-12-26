package ru.otus.springexam.service;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.domain.Question;
import org.junit.jupiter.api.*;
import ru.otus.springexam.service.LoadTestServiceImpl;

//@RunWith(SpringRunner.class)
@SpringBootTest
@EnableConfigurationProperties(YamlProps.class)
@TestPropertySource(locations= "classpath:application.yml")
@DisplayName("Загрузка данных из файла")
class LoadTestServiceImplTest {

    @Autowired
    YamlProps props;

    @Test
    void getByPath() {
        try {
            LoadTestServiceImpl loadTestService = new LoadTestServiceImpl();
            Question question = loadTestService.getByPath(props.getFilename());
            System.out.println(question);
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("fail");
        }
    }
}