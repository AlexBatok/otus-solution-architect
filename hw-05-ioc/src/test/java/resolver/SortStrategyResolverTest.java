package resolver;

import factory.AbstractSortServiceFactory;
import factory.impl.InsertionSortServiceFactory;
import factory.impl.MergeSortServiceFactory;
import factory.impl.SelectionSortServiceFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortStrategyResolverTest {

    @ParameterizedTest
    @MethodSource("argumentsForGetFactory")
    void getFactory(String strategy, AbstractSortServiceFactory expected) {
        AbstractSortServiceFactory result = SortStrategyResolver.getFactory(strategy);

        assertEquals(expected.getClass(), result.getClass());
    }

    static Stream<Arguments> argumentsForGetFactory() {
        return Stream.of(
                arguments("insert", new InsertionSortServiceFactory()),
                arguments("merge", new MergeSortServiceFactory()),
                arguments("select", new SelectionSortServiceFactory())
        );
    }
}