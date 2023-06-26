package com.yuki.common.core.controller;

import com.yuki.common.core.domain.JsonResult;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomErrorController extends AbstractErrorController {

    public CustomErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping
    public JsonResult<String> customError(HttpServletRequest request) {
        HttpStatus status = getStatus(request);
        if (HttpStatus.NOT_FOUND.equals(status)) {
            return JsonResult.notFound();
        } else {
            return JsonResult.error("发生异常");
        }
    }
}
