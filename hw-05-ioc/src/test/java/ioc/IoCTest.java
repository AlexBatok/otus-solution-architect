package ioc;

import exception.NoSuchDependencyException;
import exception.ResolveDependencyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.SortService;
import service.impl.MergeSortService;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class IoCTest {

    @Test
    @DisplayName("Проверка наличия зависимости для регистрации зависимостей")
    void test1() throws NoSuchFieldException, IllegalAccessException {
        Field mapField = IoC.class.getDeclaredField("DEPENDENCY_MAP");
        mapField.setAccessible(true);
        Map<String, Function<Object[], ?>> dependencyMap = (HashMap<String, Function<Object[], ?>>) mapField.get(null);

        assertEquals(dependencyMap.keySet().size(), 1);
        assertTrue(dependencyMap.containsKey("IoC.Register"));
    }

    @Test
    @DisplayName("Проверка работы механизма для регистрации зависимостей")
    void test2() throws NoSuchFieldException, IllegalAccessException {
        Field mapField = IoC.class.getDeclaredField("DEPENDENCY_MAP");
        mapField.setAccessible(true);
        Map<String, Function<Object[], ?>> dependencyMap = (HashMap<String, Function<Object[], ?>>) mapField.get(null);

        IoC.resolve("IoC.Register",
                "MergeSortService",
                (Function<Object[], SortService>) params -> new MergeSortService()
        );

        assertEquals(dependencyMap.keySet().size(), 2);
        assertTrue(dependencyMap.containsKey("MergeSortService"));
        assertNotNull(dependencyMap.get("MergeSortService"));
    }

    @Test
    @DisplayName("Проверка работы механизма для разрешения зависимостей (позитивный тест)")
    void test3() {
        IoC.resolve("IoC.Register",
                "MergeSortService",
                (Function<Object[], SortService>) params -> new MergeSortService()
        );

        SortService sortService = IoC.<MergeSortService>resolve("MergeSortService");

        assertNotNull(sortService);
        assertEquals("Merge Sort", sortService.getName());
    }

    @Test
    @DisplayName("Проверка работы механизма разрешения зависимостей (NoSuchDependencyException)")
    void test4() {
        IoC.resolve("IoC.Register",
                "MergeSortService",
                (Function<Object[], SortService>) params -> new MergeSortService()
        );

        Exception e = assertThrows(ResolveDependencyException.class, () -> IoC.<MergeSortService>resolve("SomeService"));
        assertTrue(e.getCause() instanceof NoSuchDependencyException);
    }
}
