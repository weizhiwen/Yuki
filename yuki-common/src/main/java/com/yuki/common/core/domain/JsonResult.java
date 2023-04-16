package com.yuki.common.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class JsonResult<T> implements BaseData {
    private static final long serialVersionUID = 1L;

    private int code;

    private String message;

    private T data;

    enum Status {
        SUCCESS(200, "操作成功"),
        WARN(400, "请求有误"),
        UNAUTHORIZED(401, "没有认证"),
        FORBIDDEN(403, "没有权限"),
        NOT_FOUND(404, "资源不存在"),
        ERROR(500, "系统异常");

        final int code;

        final String message;

        Status(int code, String message) {
            this.code = code;
            this.message = message;
        }
    }

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
        return new JsonResult<>(Status.SUCCESS.code, Status.SUCCESS.message, new PageList<T>(count, list));
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
}
