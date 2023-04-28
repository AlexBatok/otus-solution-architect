package factory.impl;

import factory.AbstractSortServiceFactory;
import service.impl.SelectionSortService;
import service.SortService;

public class SelectionSortServiceFactory implements AbstractSortServiceFactory {
    @Override
    public SortService createSortService() {
        return new SelectionSortService();
    }
}
