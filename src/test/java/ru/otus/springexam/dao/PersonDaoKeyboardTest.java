package ru.otus.springexam.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;
import ru.otus.springexam.domain.Person;
import ru.otus.springexam.domain.Question;
import ru.otus.springexam.service.ExamServiceImpl;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Ввод данных пользователя с клавиатуры")
class PersonDaoKeyboardTest {

    @Test
    @DisplayName("успешно пройдет")
    void findByName() {
        try {
            ByteArrayInputStream in = new ByteArrayInputStream("Аристов\nЕвгений\n".getBytes());
            System.setIn(in);
            //PersonDao pdk = new PersonDaoKeyboard();
            //Person person = pdk.findByName("");
            System.setIn(System.in);
            //Assertions.assertEquals("Аристов Евгений",person.getName());
        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("fail");
        }
    }
}