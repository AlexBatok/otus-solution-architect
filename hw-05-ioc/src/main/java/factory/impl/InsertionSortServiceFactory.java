package factory.impl;

import factory.AbstractSortServiceFactory;
import service.SortService;
import service.impl.InsertionSortService;

public class InsertionSortServiceFactory implements AbstractSortServiceFactory {
    @Override
    public SortService createSortService() {
        return new InsertionSortService();
    }
}
