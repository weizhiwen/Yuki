package com.yuki.common.core.controller;

import com.yuki.common.core.domain.CreateParam;
import com.yuki.common.core.domain.JsonResult;
import com.yuki.common.core.domain.UpdateParam;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.query.Queryable;
import com.yuki.common.core.reader.BaseReader;
import com.yuki.common.core.service.BaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;

public abstract class BaseController {
    public static final JsonResult<String> SUCCESS = JsonResult.success();
    private static final int MAX_PAGE_SIZE = 100;

    protected abstract BaseService getService();

    protected abstract BaseReader getReader();

    protected JsonResult<JsonResult.PageList> page(Specification query, @PageableDefault(sort = "id") Pageable pageable) {
        validatePageable(pageable);
        Page page = getService().page(query, pageable);
        BaseReader reader = getReader();
        reader.read(page.getContent());
        return JsonResult.toPage(page.getTotalElements(), getReader().fetchTargetList());
    }

    private static void validatePageable(Pageable pageable) {
        if (pageable.getPageSize() > MAX_PAGE_SIZE) {
            throw new BaseException("分页数量最大为" + MAX_PAGE_SIZE);
        }
    }

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
