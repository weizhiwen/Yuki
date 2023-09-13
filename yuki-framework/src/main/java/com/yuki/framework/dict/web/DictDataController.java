package com.yuki.framework.dict.web;

import com.yuki.common.core.controller.BaseBusinessController;
import com.yuki.common.core.dict.DictData;
import com.yuki.common.core.domain.JsonResult;
import com.yuki.framework.dict.service.DictDataReader;
import com.yuki.framework.dict.service.DictDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dict-data")
@RequiredArgsConstructor
public class DictDataController extends BaseBusinessController<DictDataParam, DictDataParam, DictData, DictDataVO> {
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
    public JsonResult<List<DictDataVO>> listAll(DictDataSearchSpecification query, Sort sort) {
        return super.listAll(query, sort);
    }

    @GetMapping
    public JsonResult<JsonResult.PageList<DictDataVO>> pageList(DictDataSearchSpecification query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @PostMapping("/search")
    public JsonResult<JsonResult.PageList<DictDataVO>> pageSearch(DictDataSearchSpecification query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @Override
    @GetMapping("/{id}")
    public JsonResult<DictDataVO> detail(@PathVariable Long id) {
        return super.detail(id);
    }

    @Override
    @PostMapping
    public JsonResult<String> create(@RequestBody DictDataParam param) {
        return super.create(param);
    }

    @Override
    @PutMapping("/{id}")
    public JsonResult<String> update(@PathVariable Long id, @RequestBody DictDataParam param) {
        return super.update(id, param);
    }

    @Override
    @DeleteMapping("/{id}")
    public JsonResult<String> delete(@PathVariable Long id) {
        return super.delete(id);
    }

    @Override
    @PatchMapping("/disable/{id}")
    public JsonResult<String> disable(@PathVariable Long id) {
        return super.disable(id);
    }

    @Override
    @PatchMapping("/enable/{id}")
    public JsonResult<String> enable(@PathVariable Long id) {
        return super.enable(id);
    }

    @Override
    @PatchMapping("/sort")
    public JsonResult<String> sort(@RequestBody Long[] ids) {
        return super.sort(ids);
    }
}
