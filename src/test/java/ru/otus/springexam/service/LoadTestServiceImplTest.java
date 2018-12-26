package ru.otus.springexam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.domain.Question;
import org.junit.jupiter.api.*;

@SpringBootTest
@EnableConfigurationProperties(YamlProps.class)
@TestPropertySource(locations= "classpath:application.yml")
@DisplayName("Загрузка данных из файла")
class LoadTestServiceImplTest {
    @Autowired
    LoadTestServiceImpl loadTestService;

    @Autowired
    YamlProps props;

    @Test
    @DisplayName("успешно закончилась")
    void getByPath() {
        try {
            Question question = loadTestService.getByPath(props.getFilename());
            Assertions.assertEquals(question.getCount(),(Integer) 6);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}