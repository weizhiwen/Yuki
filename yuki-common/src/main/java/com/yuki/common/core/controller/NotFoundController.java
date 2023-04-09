package com.yuki.common.core.controller;

import com.yuki.common.core.domain.JsonResult;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotFoundController extends AbstractErrorController {

    public NotFoundController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    @RequestMapping("/error")
    public JsonResult<String> error() {
        return JsonResult.notFound();
    }
}
