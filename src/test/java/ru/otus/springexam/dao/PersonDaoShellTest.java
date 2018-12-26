package ru.otus.springexam.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.springexam.config.YamlProps;
import ru.otus.springexam.domain.Person;

@SpringBootTest
@EnableConfigurationProperties(YamlProps.class)
@DisplayName("Ввод данных пользователя через shell")
class PersonDaoShellTest {
    @Autowired
    PersonDao pdk;

    @Test
    @DisplayName("успешно пройдет")
    void findByName() {
        try {
            Person person = pdk.findByName("Аристов Евгений");
            Assertions.assertEquals("Аристов Евгений",person.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}