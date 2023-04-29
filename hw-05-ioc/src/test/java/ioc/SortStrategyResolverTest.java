package ioc;

import exception.NoSuchSortStrategyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortStrategyResolverTest {

    @ParameterizedTest
    @MethodSource("argumentsForGetSortStrategyIdentifier")
    @DisplayName("Проверка getSortStrategyIdentifier (позитивный тест)")
    void test1(String strategy, String expected) {
        String result = SortStrategyResolver.getSortStrategyIdentifier(strategy);
        assertEquals(expected, result);
    }

    static Stream<Arguments> argumentsForGetSortStrategyIdentifier() {
        return Stream.of(
                arguments("insert", "InsertionSortService"),
                arguments("merge", "MergeSortService"),
                arguments("select", "SelectionSortService")
        );
    }

    @Test
    @DisplayName("Проверка getSortStrategyIdentifier (NoSuchSortStrategyException)")
    void test2() {
        assertThrows(NoSuchSortStrategyException.class, () -> SortStrategyResolver.getSortStrategyIdentifier("someStrategy"));
    }
}
