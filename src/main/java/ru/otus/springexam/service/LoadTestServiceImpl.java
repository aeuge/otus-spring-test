package ru.otus.springexam.service;

import org.springframework.stereotype.Service;
import ru.otus.springexam.domain.Question;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoadTestServiceImpl implements LoadTestService {
    private final String SEPARATOR = ";";

    public Question getByPath(String path) {
        URL url = ClassLoader.getSystemResource(path);
        List<String> lines = new ArrayList<>();
        try {
           lines = Files.readAllLines(Paths.get(url.getFile()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Question(lines.stream().map(line -> line.split(SEPARATOR)).collect(Collectors.toMap(line -> line[0], line -> line[1])));
    }
}
