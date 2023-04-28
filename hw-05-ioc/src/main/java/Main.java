import service.SortFileService;
import service.impl.FileReaderImpl;
import service.impl.FileWriterImpl;
import service.impl.SortFileServiceImpl;

public class Main {
    public static void main(String[] args) {
        SortFileService service = new SortFileServiceImpl(
                "insert",
                new FileReaderImpl("input.txt"),
                new FileWriterImpl("output.txt"));
        service.sortFile();
    }
}
