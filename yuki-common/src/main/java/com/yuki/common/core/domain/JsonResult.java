package com.yuki.common.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
public class JsonResult<T> implements BaseData {
    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private T data;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PageList<T> implements BaseData {
        private long count;

        private Iterable<T> list;
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

    public static <T> JsonResult<PageList<T>> toPage(long count, Iterable<T> list) {
        return new JsonResult<>(Status.SUCCESS.code, Status.SUCCESS.message, new PageList<>(count, list));
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
        return new JsonResult<>(Status.NOT_FOUND.code, Status.NOT_FOUND.message, null);
    }

    public static JsonResult<String> error(String message) {
        return new JsonResult<>(Status.ERROR.code, message, null);
    }

    enum Status {
        SUCCESS(HttpStatus.OK.value(), "操作成功"),
        WARN(HttpStatus.BAD_REQUEST.value(), "请求有误"),
        UNAUTHORIZED(HttpStatus.UNAUTHORIZED.value(), "没有认证"),
        FORBIDDEN(HttpStatus.FORBIDDEN.value(), "没有权限"),
        NOT_FOUND(HttpStatus.NOT_FOUND.value(), "资源不存在"),
        ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "系统异常");

        private final int code;

        private final String message;

        Status(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
