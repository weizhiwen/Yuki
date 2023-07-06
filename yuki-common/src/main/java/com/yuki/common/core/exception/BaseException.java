package com.yuki.common.core.exception;

import java.io.Serial;

public class BaseException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Object[] args;

    public BaseException(final Object[] args) {
        super();
        this.args = args;
    }

    public BaseException(String message) {
        super(message);
        this.args = new Object[]{};
    }

    public BaseException(String message, final Object... args) {
        super(message);
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }
}
