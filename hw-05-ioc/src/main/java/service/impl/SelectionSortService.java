package service.impl;

import service.SortService;

import java.util.List;

public class SelectionSortService implements SortService {
    @Override
    public void sort(List<Integer> inputList) {
        for (int i = 0; i < inputList.size(); i++) {
            int min = i;
            for (int j = i + 1; j < inputList.size(); j++) {
                if (inputList.get(j) < inputList.get(min)) {
                    min = j;
                }
            }
            int swap = inputList.get(i);
            inputList.set(i, inputList.get(min));
            inputList.set(min, swap);
        }
    }
}
