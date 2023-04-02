import java.util.Collections;
import java.util.List;

import static java.lang.Double.*;

public class QuadraticEquationServiceImpl implements QuadraticEquationService {

    private static final List<Double> RESTRICTED_ARGUMENTS = List.of(NaN, POSITIVE_INFINITY, NEGATIVE_INFINITY);

    @Override
    public List<Double> solve(Double a, Double b, Double c, Double epsilon) {
        double root1;
        double root2;
        List<Double> roots;

        if(isArgumentsHaveRestrictedValues(List.of(a, b, c))) {
            throw new ArithmeticException("The arguments have restricted values");
        }

        if (Math.abs(a) < epsilon) {
            throw new ArithmeticException("The 'a' coefficient cannot be zero");
        }

        double d = b * b - 4 * a * c;

        if (d < 0) {
            roots = Collections.emptyList();
        } else if (d >= 0 && d <= epsilon) {
            root1 = -b / (2 * a);
            roots = List.of(root1, root1);
        } else {
            root1 = (-b - Math.sqrt(d)) / (2 * a);
            root2 = (-b + Math.sqrt(d)) / (2 * a);
            roots = List.of(root1, root2);
        }

        return roots;
    }

    private boolean isArgumentsHaveRestrictedValues(List<Double> argumentList) {
        return !Collections.disjoint(argumentList, RESTRICTED_ARGUMENTS);
    }
}
