package factory;

import service.SortService;

public interface AbstractSortServiceFactory {
    SortService createSortService();
}
