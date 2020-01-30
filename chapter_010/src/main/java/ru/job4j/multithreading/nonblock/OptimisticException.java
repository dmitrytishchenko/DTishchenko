package ru.job4j.multithreading.nonblock;

public class OptimisticException extends RuntimeException {
    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public OptimisticException(String msg) {
        super(msg);
    }
}
