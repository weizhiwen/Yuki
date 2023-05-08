package com.yuki.framework.dict.web;

import com.yuki.framework.dict.service.DictDataReader;
import com.yuki.framework.dict.service.DictDataService;
import com.yuki.common.core.controller.BaseController;
import com.yuki.common.core.dict.DictType;
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
public class DictDataController extends BaseController {
    final DictDataService service;
    final DictDataReader reader;

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
                    @Spec(path = "code", params = "code", spec = Like.class),
                    @Spec(path = "name", params = "name", spec = Like.class),
            })
            Specification<DictType> query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @PostMapping("/search")
    public JsonResult<JsonResult.PageList> pageSearch(
            @And({
                    @Spec(path = "code", jsonPaths = "code", spec = Like.class),
                    @Spec(path = "name", jsonPaths = "name", spec = Like.class),
            })
            Specification<DictType> query, Pageable pageable) {
        return super.page(query, pageable);
    }

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

    @DeleteMapping("/{ids}")
    public JsonResult<String> delete(@PathVariable Long ids) {
        return super.delete(ids);
    }
}
