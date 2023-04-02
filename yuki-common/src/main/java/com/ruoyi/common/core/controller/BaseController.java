package com.ruoyi.common.core.controller;

import com.ruoyi.common.core.domain.JsonResult;
import com.ruoyi.common.core.service.BaseService;

public abstract class BaseController {
    public static final JsonResult<String> SUCCESS = JsonResult.success();

    protected abstract BaseService getService();

}
