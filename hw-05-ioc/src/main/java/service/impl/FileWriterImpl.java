package service.impl;

import exception.FileWriterException;
import service.FileWriter;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    private final String fileName;

    public FileWriterImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void writeToFile(List<String> strings) {
        try {
            Path path = Paths.get("hw-05-ioc/src/main/resources/" + fileName);
            Files.write(path, strings, Charset.defaultCharset());
        } catch (Exception e) {
            throw new FileWriterException(e);
        }
    }
}
