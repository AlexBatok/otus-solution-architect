package service.impl;

import service.SortService;

import java.util.List;

public class InsertionSortService implements SortService {
    @Override
    public void sort(List<Integer> inputList) {
        for(int j = 1; j < inputList.size(); j++) {
            int current = inputList.get(j);
            int i = j - 1;
            while (i > -1 && inputList.get(i) > current) {
                inputList.set(i + 1, inputList.get(i));
                i--;
            }
            inputList.set(i + 1, current);
        }
    }
}
