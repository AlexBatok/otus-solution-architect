package service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.FileReader;
import service.FileWriter;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class SortFileServiceImplTest {

    SortFileServiceImpl sortFileService;
    FileReader fileReader;
    FileWriter fileWriter;


    @BeforeEach
    void setUp() {
        fileWriter = mock(FileWriter.class);
        fileReader = mock(FileReader.class);
    }

    @Test
    void sortFile() {
        String sortStrategy = "insert";
        List<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(3);
        unsortedList.add(0);
        unsortedList.add(1);

        List<String> sortedList = List.of("insert", "0", "1", "3");

        doReturn(unsortedList)
                .when(fileReader)
                .readNumsFromFile();
        doNothing()
                .when(fileWriter)
                .writeToFile(anyList());


        sortFileService = new SortFileServiceImpl(sortStrategy, fileReader, fileWriter);

        sortFileService.sortFile();

        verify(fileReader).readNumsFromFile();
        verify(fileWriter).writeToFile(sortedList);
    }
}