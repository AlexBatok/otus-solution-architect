import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Double.*;
import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationServiceImplTest {
    private static final Double E = 0.0001;

    private final QuadraticEquationService service = new QuadraticEquationServiceImpl();
    private Double a, b, c;

    @Test
    @DisplayName("x^2+1 = 0 has no roots")
    void solve1() {
        // arrange
        a = 1.0;
        b = 0.0;
        c = 1.0;

        // act
        List<Double> result = service.solve(a, b, c, E);

        // assert
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("x^2-1 = 0 has two roots with a multiplicity of 1")
    void solve2() {
        // arrange
        a = 1.0;
        b = 0.0;
        c = -1.0;

        // act
        List<Double> result = service.solve(a, b, c, E);

        // assert
        assertEquals(2, result.size());
        assertTrue(result.contains(-1.0));
        assertTrue(result.contains(1.0));
    }

    @Test
    @DisplayName("x^2 + 2.00001x + 1.0 = 0 has one root with a multiplicity of 2 and 0 < D < e")
    void solve3() {
        // arrange
        a = 1.0;
        b = 2.00001;
        c = 1.0;

        // act
        List<Double> result = service.solve(a, b, c, E);

        // assert
        assertTrue(b * b - 4* a * c > 0 && b * b - 4* a * c < E);
        assertEquals(2, result.size());
        assertEquals(result.get(0), result.get(1));
    }

    @Test
    @DisplayName("When 'a' equals zero then throw ArithmeticException")
    void solve4() {
        // arrange
        a = 0.0;
        b = 2.0;
        c = 1.0;

        // act
        Exception e = assertThrows(ArithmeticException.class,
                () -> service.solve(a, b, c, E));

        // assert
        assertEquals("The 'a' coefficient cannot be zero", e.getMessage());
    }

    @Test
    @DisplayName("When arguments have restricted values then throw ArithmeticException")
    void solve5() {
        // arrange
        a = NaN;
        b = POSITIVE_INFINITY;
        c = NEGATIVE_INFINITY;

        // act
        Exception e = assertThrows(ArithmeticException.class,
                () -> service.solve(a, b, c, E));

        // assert
        assertEquals("The arguments have restricted values", e.getMessage());
    }
}