package ioc;

import exception.NoSuchSortStrategyException;

import java.util.Map;

public class SortStrategyResolver {
    private static final Map<String, String> SORT_STRATEGY_MAP = Map.of(
            "merge", "MergeSortService",
            "insert",  "InsertionSortService",
            "select", "SelectionSortService"
    );

    public static String getSortStrategyIdentifier(String sortStrategy) {
        if (sortStrategy == null || SORT_STRATEGY_MAP.get(sortStrategy) == null) {
            throw new NoSuchSortStrategyException();
        }
        return SORT_STRATEGY_MAP.get(sortStrategy);
    }
}
