package com.yuki.common.core.exception;

public class UserPasswordNotMatchException extends BaseException {
    public UserPasswordNotMatchException() {
        super("user.password.not.match");
    }
}
