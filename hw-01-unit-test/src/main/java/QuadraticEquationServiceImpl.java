import java.util.Collections;
import java.util.List;

public class QuadraticEquationServiceImpl implements QuadraticEquationService {
    @Override
    public List<Double> solve(Double a, Double b, Double c) {
        double d = b * b - 4 * a * c;
        if (d < 0) {
            return Collections.emptyList();
        }

        Double x1 = (-b - Math.sqrt(d)) / (2 * a);
        Double x2 = (-b + Math.sqrt(d)) / (2 * a);
        return List.of(x1, x2);
    }
}
