package ua.kpi.exception;

public class UnrecognizedRequestException extends RuntimeException {

    public UnrecognizedRequestException() {
    }

    public UnrecognizedRequestException(String m) {
        super(m);
    }
}
