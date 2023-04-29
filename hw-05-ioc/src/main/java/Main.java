import ioc.IoC;
import service.SortFileService;
import service.impl.SortFileServiceImpl;

public class Main {
    public static void main(String[] args) {
        AppInitializer.init();
        SortFileService service = IoC.<SortFileServiceImpl>resolve("SortFileServiceImpl", "select", "input.txt", "output.txt");
        service.sortFile();
    }
}
