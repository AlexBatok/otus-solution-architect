package service.impl;

import exception.FileReaderException;
import service.FileReader;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderImpl implements FileReader {
    private final String fileName;

    public FileReaderImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Integer> readNumsFromFile() {

        Path path = Paths.get("hw-05-ioc/src/main/resources/" + fileName);

        try (Stream<String> stream = Files.lines(path)) {
            return stream
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new FileReaderException(e);
        }
    }
}
