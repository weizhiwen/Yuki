package com.yuki.admin.position.web;

import com.yuki.admin.position.dao.Position;
import com.yuki.admin.position.service.PositionParam;
import com.yuki.admin.position.service.PositionReader;
import com.yuki.admin.position.service.PositionService;
import com.yuki.admin.position.service.PositionVO;
import com.yuki.common.core.controller.BaseBusinessController;
import com.yuki.common.core.domain.JsonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/positions")
@RequiredArgsConstructor
@RestController
public class PositionController extends BaseBusinessController<PositionParam, PositionParam, Position, PositionVO> {
    private final PositionService service;
    private final PositionReader reader;

    @Override
    protected PositionService getService() {
        return service;
    }

    @Override
    protected PositionReader getReader() {
        return reader;
    }

    @GetMapping
    public JsonResult<JsonResult.PageList<PositionVO>> pageList(PositionSearchSpecification query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @PostMapping("/search")
    public JsonResult<JsonResult.PageList<PositionVO>> pageSearch(PositionSearchSpecification query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @Override
    @GetMapping("/{id}")
    public JsonResult<PositionVO> detail(@PathVariable Long id) {
        return super.detail(id);
    }

    @Override
    @PostMapping
    public JsonResult<String> create(@RequestBody PositionParam param) {
        return super.create(param);
    }

    @Override
    @PutMapping("/{id}")
    public JsonResult<String> update(@PathVariable Long id, @RequestBody PositionParam param) {
        return super.update(id, param);
    }

    @Override
    @DeleteMapping("/{ids}")
    public JsonResult<String> delete(@PathVariable Long[] ids) {
        return super.delete(ids);
    }
}
