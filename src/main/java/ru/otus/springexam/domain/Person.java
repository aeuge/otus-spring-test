package ru.otus.springexam.domain;

import org.springframework.beans.factory.annotation.Value;

public class Person {

    private String name;
    private int age;

    private long percentCorrectAnswers;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.percentCorrectAnswers = 0;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setPercentCorrectAnswers(long percentCorrectAnswers) {
        this.percentCorrectAnswers = percentCorrectAnswers;
    }

    public long getPercentCorrectAnswers() {
        return percentCorrectAnswers;
    }
}
