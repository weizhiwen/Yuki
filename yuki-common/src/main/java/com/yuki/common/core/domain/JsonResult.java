package com.yuki.common.core.domain;

import lombok.Getter;

@Getter
public class JsonResult<T> extends BaseData {
    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private T data;

    enum Status {
        SUCCESS(200, "操作成功"),
        WARN(400, "请求有误"),
        UNAUTHORIZED(401, "没有认证"),
        FORBIDDEN(403, "没有权限"),
        NOT_FOUND(404, "没有找到"),
        ERROR(500, "系统异常");

        final int code;

        final String message;

        Status(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

    public JsonResult() {
    }

    public JsonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static JsonResult<String> success() {
        return new JsonResult<>(Status.SUCCESS.code, Status.SUCCESS.message, null);
    }

    public static <T> JsonResult<T> success(T data) {
        return new JsonResult<>(Status.SUCCESS.code, Status.SUCCESS.message, data);
    }

    public static JsonResult<String> warn() {
        return new JsonResult<>(Status.WARN.code, Status.WARN.message, null);
    }

    public static JsonResult<String> warn(String message) {
        return new JsonResult<>(Status.WARN.code, message, null);
    }

    public static JsonResult<String> unauthorized() {
        return new JsonResult<>(Status.UNAUTHORIZED.code, Status.UNAUTHORIZED.message, null);
    }

    public static JsonResult<String> forbidden() {
        return new JsonResult<>(Status.UNAUTHORIZED.code, Status.UNAUTHORIZED.message, null);
    }

    public static JsonResult<String> notFound() {
        return new JsonResult<>(Status.UNAUTHORIZED.code, Status.UNAUTHORIZED.message, null);
    }

    public static JsonResult<String> error() {
        return new JsonResult<>(Status.ERROR.code, Status.ERROR.message, null);
    }

    public static JsonResult<String> error(String message) {
        return new JsonResult<>(Status.ERROR.code, message, null);
    }
}
