package com.yuki.admin.position.controller;

import com.yuki.admin.position.service.PositionService;
import com.yuki.common.core.controller.BaseController;
import com.yuki.common.core.domain.JsonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/position")
@RequiredArgsConstructor
@RestController
public class PositionController extends BaseController {
    private final PositionService service;

    @Override
    protected PositionService getService() {
        return service;
    }

    @PostMapping
    public JsonResult<String> create(@RequestBody PositionParam param) {
        return super.create(param);
    }

    @PutMapping("/{id}")
    public JsonResult<String> create(@PathVariable Long id, @RequestBody PositionParam param) {
        return super.update(id, param);
    }

    @DeleteMapping("/{id}")
    public JsonResult<String> delete(@PathVariable Long id) {
        return super.delete(id);
    }
}
