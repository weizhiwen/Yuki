package com.yuki.framework.dict.web;

import com.yuki.framework.dict.service.DictTypeReader;
import com.yuki.framework.dict.service.DictTypeService;
import com.yuki.common.core.controller.BaseBusinessController;
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
@RequestMapping("/dict-types")
@RequiredArgsConstructor
public class DictTypeController extends BaseBusinessController {
    private final DictTypeService service;
    private final DictTypeReader reader;

    @Override
    protected DictTypeService getService() {
        return service;
    }

    @Override
    protected DictTypeReader getReader() {
        return reader;
    }

    @GetMapping
    public JsonResult<JsonResult.PageList> pageList(
            @And({
                    @Spec(path = DictType.CODE_FIELD, jsonPaths = DictType.CODE_FIELD, spec = Like.class),
                    @Spec(path = DictType.NAME_FIELD, jsonPaths = DictType.NAME_FIELD, spec = Like.class),
            })
            Specification<DictType> query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @PostMapping("/search")
    public JsonResult<JsonResult.PageList> pageSearch(
            @And({
                    @Spec(path = DictType.CODE_FIELD, jsonPaths = DictType.CODE_FIELD, spec = Like.class),
                    @Spec(path = DictType.NAME_FIELD, jsonPaths = DictType.NAME_FIELD, spec = Like.class),
            })
            Specification<DictType> query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @Override
    @GetMapping("/{id}")
    public JsonResult<DictTypeVO> detail(@PathVariable Long id) {
        return super.detail(id);
    }

    @PostMapping
    public JsonResult<String> create(@RequestBody DictTypeParam param) {
        return super.create(param);
    }

    @PutMapping("/{id}")
    public JsonResult<String> update(@PathVariable Long id, @RequestBody DictTypeParam param) {
        return super.update(id, param);
    }

    @Override
    @DeleteMapping("/{ids}")
    public JsonResult<String> delete(@PathVariable Long ids) {
        return super.delete(ids);
    }
}
