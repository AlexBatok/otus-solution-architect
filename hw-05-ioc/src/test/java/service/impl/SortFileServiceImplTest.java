package service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.FileReader;
import service.FileWriter;
import service.SortService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

class SortFileServiceImplTest {

    SortFileServiceImpl sortFileService;
    FileReader fileReader;
    FileWriter fileWriter;
    SortService sortService;


    @BeforeEach
    void setUp() {
        fileWriter = mock(FileWriter.class);
        fileReader = mock(FileReader.class);
        sortService = mock(SortService.class);
    }

    @Test
    void sortFile() {
        List<Integer> unsortedList = new ArrayList<>();
        unsortedList.add(3);
        unsortedList.add(0);
        unsortedList.add(1);

        doNothing()
                .when(sortService)
                .sort(anyList());
        doReturn(unsortedList)
                .when(fileReader)
                .readNumsFromFile();
        doNothing()
                .when(fileWriter)
                .writeToFile(anyList());
        sortFileService = new SortFileServiceImpl(sortService, fileReader, fileWriter);

        sortFileService.sortFile();

        verify(fileReader).readNumsFromFile();
        verify(sortService).sort(anyList());
        verify(fileWriter).writeToFile(anyList());
    }
}
