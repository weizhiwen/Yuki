package com.yuki.framework.dict.web;

import com.yuki.common.core.dict.DictData;
import com.yuki.framework.dict.service.DictDataReader;
import com.yuki.framework.dict.service.DictDataService;
import com.yuki.common.core.controller.BaseBusinessController;
import com.yuki.common.core.domain.JsonResult;
import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public JsonResult<JsonResult.PageList> pageList(
            @And({
                    @Spec(path = DictData.CODE_FIELD, params = DictData.CODE_FIELD, spec = Like.class),
                    @Spec(path = DictData.NAME_FIELD, params = DictData.NAME_FIELD, spec = Like.class),
            })
            Specification<DictData> query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @PostMapping("/search")
    public JsonResult<JsonResult.PageList> pageSearch(
            @And({
                    @Spec(path = DictData.CODE_FIELD, jsonPaths = DictData.CODE_FIELD, spec = Like.class),
                    @Spec(path = DictData.NAME_FIELD, jsonPaths = DictData.NAME_FIELD, spec = Like.class),
            })
            Specification<DictData> query, Pageable pageable) {
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
