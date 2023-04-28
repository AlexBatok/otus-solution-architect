package service.impl;

import factory.AbstractSortServiceFactory;
import resolver.SortStrategyResolver;
import service.FileReader;
import service.FileWriter;
import service.SortFileService;

import java.util.List;
import java.util.stream.Collectors;

public class SortFileServiceImpl implements SortFileService {
    private final AbstractSortServiceFactory factory;
    private final FileReader fileReader;
    private final FileWriter fileWriter;
    private final String sortStrategy;

    public SortFileServiceImpl(String sortStrategy, FileReader fileReader, FileWriter fileWriter) {
        this.factory = SortStrategyResolver.getFactory(sortStrategy);
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.sortStrategy = sortStrategy;
    }

    @Override
    public void sortFile() {
        List<Integer> listToSort = fileReader.readNumsFromFile();
        factory.createSortService().sort(listToSort);
        fileWriter.writeToFile(buildResultListWithSortStrategy(sortStrategy, listToSort));
    }

    private List<String> buildResultListWithSortStrategy(String sortStrategyName, List<Integer> nums) {
        List<String> list = nums.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        list.add(0, sortStrategyName);
        return list;
    }
}
