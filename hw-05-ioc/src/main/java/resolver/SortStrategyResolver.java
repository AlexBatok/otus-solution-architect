package resolver;

import exception.NoSuchSortStrategyException;
import factory.AbstractSortServiceFactory;
import factory.impl.InsertionSortServiceFactory;
import factory.impl.MergeSortServiceFactory;
import factory.impl.SelectionSortServiceFactory;

import java.util.Map;

public class SortStrategyResolver {
    private static final Map<String, AbstractSortServiceFactory> FACTORY_MAP = Map.of(
            "merge", new MergeSortServiceFactory(),
            "insert", new InsertionSortServiceFactory(),
            "select", new SelectionSortServiceFactory()
    );

    public static AbstractSortServiceFactory getFactory(String sortStrategy) {
        if (sortStrategy == null || FACTORY_MAP.get(sortStrategy) == null) {
            throw new NoSuchSortStrategyException();
        }
        return FACTORY_MAP.get(sortStrategy);
    }
}
