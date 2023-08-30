package com.yuki.framework.dict.web;

import com.yuki.common.core.controller.BaseBusinessController;
import com.yuki.common.core.domain.JsonResult;
import com.yuki.framework.dict.service.DictDataReader;
import com.yuki.framework.dict.service.DictDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dict-data")
@RequiredArgsConstructor
public class DictDataController extends BaseBusinessController {
    private final DictDataService service;
    private final DictDataReader reader;

    @Override
    protected DictDataService getService() {
        return service;
    }

    @Override
    protected DictDataReader getReader() {
        return reader;
    }

    @GetMapping("/all")
    public JsonResult<List> listAll(DictDataSearchSpecification query) {
        return super.listAll(query);
    }

    @GetMapping
    public JsonResult<JsonResult.PageList> pageList(DictDataSearchSpecification query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @PostMapping("/search")
    public JsonResult<JsonResult.PageList> pageSearch(DictDataSearchSpecification query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @Override
    @GetMapping("/{id}")
    public JsonResult<DictDataVO> detail(@PathVariable Long id) {
        return super.detail(id);
    }

    @PostMapping
    public JsonResult<String> create(@RequestBody DictDataParam param) {
        return super.create(param);
    }

    @PutMapping("/{id}")
    public JsonResult<String> update(@PathVariable Long id, @RequestBody DictDataParam param) {
        return super.update(id, param);
    }

    @Override
    @DeleteMapping("/{ids}")
    public JsonResult<String> delete(@PathVariable Long ids) {
        return super.delete(ids);
    }
}
