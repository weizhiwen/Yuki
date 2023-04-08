package com.yuki.common.core.controller;

import com.yuki.common.core.domain.JsonResult;
import com.yuki.common.core.service.BaseService;

public abstract class BaseController {
    public static final JsonResult<String> SUCCESS = JsonResult.success();

    protected abstract BaseService getService();

}
