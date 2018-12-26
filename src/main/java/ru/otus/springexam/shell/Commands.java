package ru.otus.springexam.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;
import ru.otus.springexam.service.MainExam;

import static ru.otus.springexam.service.MainExamImpl.LOCAL;

@ShellComponent
public class Commands {
    @Autowired
    private final MainExam mainExam;

    public Commands(MainExam mainExam, MessageSource messageSource) {
        this.mainExam = mainExam;
        System.out.println(messageSource.getMessage( "enter.name",new String[]{},LOCAL));
    }

    @ShellMethod("Задать Фамилию и имя")
    public String start(@ShellOption String fam, String name) {
        mainExam.startExam(fam + " " + name);
        return mainExam.getQuestion();
    }

    @ShellMethod("Ответить на текущий вопрос")
    public String answer(@ShellOption String answer) {
        return mainExam.setQuestion(answer);
    }
}
