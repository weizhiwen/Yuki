package com.yuki.common.core.exception;

import com.yuki.common.core.domain.JsonResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    final MessageSource messageSource;

    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public JsonResult<String> handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return JsonResult.forbidden();
    }

    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JsonResult<String> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
                                                          HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
        return JsonResult.warn(e.getMessage());
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(BaseException.class)
    public JsonResult<String> handleBaseException(BaseException e, HttpServletRequest request)
    {
        log.error(e.getMessage(), e);
        return JsonResult.error(messageSource.getMessage(e.getMessage(), e.getArgs(), LocaleContextHolder.getLocale()));
    }

    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public JsonResult<String> handleRuntimeException(RuntimeException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知的运行时异常.", requestURI, e);
        return JsonResult.error(e.getMessage());
    }

    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public JsonResult<String> handleException(Exception e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return JsonResult.error(e.getMessage());
    }

    /**
     * 最顶级异常
     */
    @ExceptionHandler(Throwable.class)
    public JsonResult<String> handleThrowable(Throwable e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知Throwable.", requestURI, e);
        return JsonResult.error(e.getMessage());
    }

    /**
     * 验证异常
     */
    @ExceptionHandler(BindException.class)
    public JsonResult<String> handleBindException(BindException e)
    {
        log.warn(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return JsonResult.warn(message);
    }

    /**
     * 验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public JsonResult<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        log.warn(e.getMessage(), e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return JsonResult.warn(message);
    }
}
