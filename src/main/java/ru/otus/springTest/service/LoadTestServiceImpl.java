package ru.otus.springTest.service;

import ru.otus.springTest.domain.Question;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoadTestServiceImpl implements LoadTestService {
    private final String SEPARATOR = ";";

    public LoadTestServiceImpl() {
    }


    public Question getByPath(String path) {
        Path pathTestFile = Paths.get(path);
        List<String> lines = new ArrayList<>();
        try {
           lines = Files.readAllLines(pathTestFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Question(lines.stream().map(line -> line.split(SEPARATOR)).collect(Collectors.toMap(line -> line[0], line -> line[1])));
    }
}