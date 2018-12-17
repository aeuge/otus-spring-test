package ru.otus.springTest.domain;

import java.util.HashMap;
import java.util.Map;

public class Question{
    private Map<String, String> mapOfQuestions;

    public Question(Map<String, String> mapOfQuestions) {
        this.mapOfQuestions = mapOfQuestions;
    }

    public void add (String k, String v) {
        mapOfQuestions.put(k,v);
    }
}
