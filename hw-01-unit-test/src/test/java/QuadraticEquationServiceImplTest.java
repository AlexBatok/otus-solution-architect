import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuadraticEquationServiceImplTest {

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
        List<Double> result = service.solve(a, b, c);

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
        List<Double> result = service.solve(a, b, c);

        // assert
        assertEquals(2, result.size());
        assertTrue(result.contains(-1.0));
        assertTrue(result.contains(1.0));
    }
}