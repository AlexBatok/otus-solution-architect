package exception;

public class FileReaderException extends RuntimeException {
    public FileReaderException(Throwable cause) {
        super("Exception while reading file", cause);
    }
}
