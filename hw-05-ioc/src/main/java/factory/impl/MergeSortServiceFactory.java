package factory.impl;

import factory.AbstractSortServiceFactory;
import service.impl.MergeSortService;
import service.SortService;

public class MergeSortServiceFactory implements AbstractSortServiceFactory {
    @Override
    public SortService createSortService() {
        return new MergeSortService();
    }
}
