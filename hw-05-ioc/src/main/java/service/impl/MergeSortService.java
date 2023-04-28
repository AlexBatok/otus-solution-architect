package service.impl;

import service.SortService;

import java.util.ArrayList;
import java.util.List;

public class MergeSortService implements SortService {

    @Override
    public void sort(List<Integer> inputList) {
        mergeSort(inputList, 0, inputList.size() - 1);
    }

    private void mergeSort(List<Integer> list, int low, int high) {
        if (high <= low) return;

        int mid = (low + high) / 2;
        mergeSort(list, low, mid);
        mergeSort(list, mid + 1, high);
        merge(list, low, mid, high);
    }

    private void merge(List<Integer> list, int low, int mid, int high) {
        int leftListCapacity = mid - low + 1;
        List<Integer> leftList = new ArrayList<>(leftListCapacity);

        int rightListCapacity = high - mid;
        List<Integer> rightList = new ArrayList<>(rightListCapacity);

        for (int i = 0; i < leftListCapacity; i++)
            leftList.add(i, list.get(low + i));
        for (int i = 0; i < rightListCapacity; i++)
            rightList.add(i, list.get(mid + i + 1));

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftListCapacity && rightIndex < rightListCapacity) {
                if (leftList.get(leftIndex) < rightList.get(rightIndex)) {
                    list.set(i, leftList.get(leftIndex));
                    leftIndex++;
                } else {
                    list.set(i, rightList.get(rightIndex));
                    rightIndex++;
                }
            } else if (leftIndex < leftListCapacity) {
                list.set(i, leftList.get(leftIndex));
                leftIndex++;
            } else if (rightIndex < rightListCapacity) {
                list.set(i, rightList.get(rightIndex));
                rightIndex++;
            }
        }
    }
}
