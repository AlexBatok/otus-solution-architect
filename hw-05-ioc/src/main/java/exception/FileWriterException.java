package exception;

public class FileWriterException extends RuntimeException {
    public FileWriterException(Throwable cause) {
        super("Exception while writing to file", cause);
    }
}
