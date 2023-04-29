import ioc.IoC;
import ioc.SortStrategyResolver;
import service.FileReader;
import service.FileWriter;
import service.SortService;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.InsertionSortService;
import service.impl.MergeSortService;
import service.impl.SelectionSortService;
import service.impl.SortFileServiceImpl;

import java.util.function.Function;

public class AppInitializer {
    public static void init() {
        IoC.resolve("IoC.Register",
                "MergeSortService",
                (Function<Object[], SortService>) params -> new MergeSortService()
        );
        IoC.resolve("IoC.Register",
                "SelectionSortService",
                (Function<Object[], SortService>) params -> new SelectionSortService()
        );
        IoC.resolve("IoC.Register",
                "InsertionSortService",
                (Function<Object[], SortService>) params -> new InsertionSortService()
        );
        IoC.resolve("IoC.Register",
                "FileReaderImpl",
                (Function<Object[], FileReader>) params -> new FileReaderImpl((String)params[0])
        );
        IoC.resolve("IoC.Register",
                "FileWriterImpl",
                (Function<Object[], FileWriter>) params -> new FileWriterImpl((String)params[0])
        );
        IoC.resolve("IoC.Register",
                "SortFileServiceImpl",
                (Function<Object[], SortFileServiceImpl>) params -> new SortFileServiceImpl(
                        IoC.resolve(SortStrategyResolver.getSortStrategyIdentifier((String) params[0])),
                        IoC.resolve("FileReaderImpl", (String) params[1]),
                        IoC.resolve("FileWriterImpl", (String) params[2])
                )
        );
    }
}
