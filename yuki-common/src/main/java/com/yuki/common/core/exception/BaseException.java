package com.yuki.common.core.exception;

public class BaseException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private Object[] args;

    public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Object[] args) {
        super(message);
        this.args = args;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
