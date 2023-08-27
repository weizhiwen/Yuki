package com.yuki.common.constant;

import java.math.BigDecimal;

public final class Constants {
    private Constants() {
    }

    public static final String LOGIN_SESSION_ID = "session_id";
    public static final String LOGIN_USER_NAME = "user_name";

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final int MINI_STRING_LENGTH = 8;
    public static final int SHORT_STRING_LENGTH = 16;
    public static final int MEDIUM_STRING_LENGTH = 32;
    public static final int LONG_STRING_LENGTH = 64;
    public static final int MAX_STRING_LENGTH = 255;

    public static final int BIG_DECIMAL_MAX_PRECISION = 38;

    public static final int BIG_DECIMAL_MAX_SCALE = 16;

    public static final BigDecimal DEPARTMENT_DIVISOR = BigDecimal.valueOf(3);

    public static final String SEARCH_KEYWORD_FIELD = "keyword";
}
