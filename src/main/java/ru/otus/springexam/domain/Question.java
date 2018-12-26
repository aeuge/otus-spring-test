package ru.otus.springexam.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question{
    private Map<String, String> mapOfQuestions;

    public Question(Map<String, String> mapOfQuestions) {
        this.mapOfQuestions = mapOfQuestions;
    }
    public Question() {mapOfQuestions = new HashMap<>();}

    public void add(String k, String v) {
        mapOfQuestions.put(k,v);
    }

    public List<String> keys() {
        return new ArrayList<>(mapOfQuestions.keySet());
    }

    public String get(String key) {
        return mapOfQuestions.get(key);
    }

    public String toString() {
        return mapOfQuestions.toString();
    }

    public Integer getCount() {
        return mapOfQuestions.size();
    }
}
