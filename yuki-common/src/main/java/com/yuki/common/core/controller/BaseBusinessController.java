package com.yuki.common.core.controller;

import com.yuki.common.core.domain.CreateParam;
import com.yuki.common.core.domain.JsonResult;
import com.yuki.common.core.domain.UpdateParam;
import com.yuki.common.core.domain.entity.BaseEntity;
import com.yuki.common.core.exception.BaseException;
import com.yuki.common.core.reader.BaseReader;
import com.yuki.common.core.service.BaseBusinessService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;

import java.util.List;

public abstract class BaseBusinessController<C extends CreateParam, U extends UpdateParam, T extends BaseEntity, V> {
    public static final JsonResult<String> SUCCESS = JsonResult.success();
    private static final int MAX_PAGE_SIZE = 100;

    protected abstract BaseBusinessService<C, U, T, V> getService();

    protected abstract BaseReader<T, V> getReader();

    protected JsonResult<List<V>> listAll(Specification<T> query, Sort sort) {
        BaseReader<T, V> reader = getReader();
        getService().executeListWithReader(() -> getService().list(query, sort), reader);
        return JsonResult.success(reader.fetchTargetList());
    }

    protected JsonResult<JsonResult.PageList<V>> page(Specification<T> query, @PageableDefault(sort = "id") Pageable pageable) {
        validatePageable(pageable);
        Page<T> page = getService().page(query, pageable);
        BaseReader<T, V> reader = getReader();
        getService().executeListWithReader(page::getContent, reader);
        return JsonResult.toPage(page.getTotalElements(), reader.fetchTargetList());
    }

    private static void validatePageable(Pageable pageable) {
        if (pageable.getPageSize() > MAX_PAGE_SIZE) {
            throw new BaseException("分页数量最大为" + MAX_PAGE_SIZE);
        }
    }

    protected JsonResult<V> detail(Long id) {
        BaseReader<T, V> reader = getReader();
        getService().executeWithReader(() -> getService().get(id), reader);
        return JsonResult.success(reader.fetchTarget());
    }

    protected JsonResult<String> create(C param) {
        getService().create(param);
        return SUCCESS;
    }

    protected JsonResult<String> update(Long id, U param) {
        param.setId(id);
        getService().update(param);
        return SUCCESS;
    }

    protected JsonResult<String> delete(Long id) {
        getService().delete(id);
        return SUCCESS;
    }

    protected JsonResult<String> delete(Long[] ids) {
        for (Long id : ids) {
            getService().delete(id);
        }
        return SUCCESS;
    }

    protected JsonResult<String> disable(Long id) {
        getService().disable(id, Boolean.TRUE);
        return SUCCESS;
    }

    protected JsonResult<String> enable(Long id) {
        getService().disable(id, Boolean.FALSE);
        return SUCCESS;
    }

    protected JsonResult<String> sort(Long[] ids) {
        getService().sort(ids);
        return SUCCESS;
    }
}