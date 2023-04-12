package com.yuki.common.core.controller;

import com.yuki.common.core.domain.CreateParam;
import com.yuki.common.core.domain.JsonResult;
import com.yuki.common.core.domain.UpdateParam;
import com.yuki.common.core.service.BaseService;

public abstract class BaseController {
    public static final JsonResult<String> SUCCESS = JsonResult.success();

    protected abstract BaseService getService();

    protected JsonResult<String> create(CreateParam param) {
        getService().create(param);
        return SUCCESS;
    }

    protected JsonResult<String> update(Long id, UpdateParam param) {
        param.setId(id);
        getService().update(param);
        return SUCCESS;
    }

    protected JsonResult<String> delete(Long id) {
        getService().delete(id);
        return SUCCESS;
    }
}
