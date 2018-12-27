package ru.otus.springexam.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.otus.springexam.dao.PersonDao;
import ru.otus.springexam.domain.Person;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
@DisplayName("Тестирование DAO пользователя")
class PersonServiceImplTest {
    @Autowired
    PersonService personService;

    @MockBean
    PersonDao personDao;

    @Test
    @DisplayName("успешно пройдено")
    void getByName() {
        try {
            Person person = new Person("Аристов Евгений", 10);
            when(personDao.findByName(anyString())).thenReturn(person);

            Person personReturned = personService.getByName("Иван");
            Assertions.assertEquals(person,personReturned);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}