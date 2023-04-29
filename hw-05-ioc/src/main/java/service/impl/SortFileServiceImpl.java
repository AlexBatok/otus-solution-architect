package service.impl;

import service.FileReader;
import service.FileWriter;
import service.SortFileService;
import service.SortService;

import java.util.List;
import java.util.stream.Collectors;

public class SortFileServiceImpl implements SortFileService {
    private final SortService sortService;
    private final FileReader fileReader;
    private final FileWriter fileWriter;

    public SortFileServiceImpl(SortService sortService, FileReader fileReader, FileWriter fileWriter) {
        this.sortService = sortService;
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    @Override
    public void sortFile() {
        List<Integer> listToSort = fileReader.readNumsFromFile();
        sortService.sort(listToSort);
        fileWriter.writeToFile(buildResultListWithSortStrategy(sortService.getName(), listToSort));
    }

    private List<String> buildResultListWithSortStrategy(String sortStrategyName, List<Integer> nums) {
        List<String> list = nums.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        list.add(0, sortStrategyName);
        return list;
    }
}
