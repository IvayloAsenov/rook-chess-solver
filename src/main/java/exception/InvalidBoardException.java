package exception;

public class InvalidBoardException extends RuntimeException {
    public InvalidBoardException() {
        super();
    }

    public InvalidBoardException(String message) {
        super(message);
    }

    public InvalidBoardException(String message, Throwable cause) {
        super(message, cause);
    }
}
