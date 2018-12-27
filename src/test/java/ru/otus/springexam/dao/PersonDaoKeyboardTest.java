package ru.otus.springexam.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.domain.Person;
import java.io.ByteArrayInputStream;

@SpringBootTest
@EnableConfigurationProperties(YamlProps.class)
@DisplayName("Ввод данных пользователя с клавиатуры")
class PersonDaoKeyboardTest {
    @Autowired
    PersonDao pdk;

    @MockBean
    CommandLineRunner commandLineRunner;

    @Autowired
    YamlProps props;

    @Test
    @DisplayName("успешно пройдет")
    void findByName() {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream("Аристов\nЕвгений\n".getBytes());
            System.setIn(in);
            Person person = pdk.findByName("");
            System.setIn(System.in);
            Assertions.assertEquals("Аристов Евгений",person.getName());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("fail");
        }
    }
}