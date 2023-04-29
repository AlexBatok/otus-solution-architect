package ioc;

import exception.NoSuchDependencyException;
import exception.ResolveDependencyException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class IoC {
    private static final Map<String, Function<Object[], ?>> DEPENDENCY_MAP;

    static {
       DEPENDENCY_MAP = new HashMap<>();
       DEPENDENCY_MAP.put("IoC.Register", args -> DEPENDENCY_MAP.put((String) args[0], (Function<Object[], ?>) args[1]));
    }

    public static <T> T resolve(String key, Object... args) {
        try {
            if (!DEPENDENCY_MAP.containsKey(key)) {
                throw new NoSuchDependencyException(key);
            }
            return (T) DEPENDENCY_MAP.get(key).apply(args);
        } catch (Exception e) {
            throw new ResolveDependencyException(e);
        }
    }
}
