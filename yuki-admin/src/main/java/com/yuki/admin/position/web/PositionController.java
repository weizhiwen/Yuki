package com.yuki.admin.position.web;

import com.yuki.admin.position.dao.Position;
import com.yuki.admin.position.service.PositionMapper;
import com.yuki.admin.position.service.PositionReader;
import com.yuki.admin.position.service.PositionService;
import com.yuki.common.core.controller.BaseController;
import com.yuki.common.core.dict.Dict;
import com.yuki.common.core.domain.JsonResult;
import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/position")
@RequiredArgsConstructor
@RestController
public class PositionController extends BaseController {
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
    public JsonResult<JsonResult.PageList> pageList(
            @And({
                    @Spec(path = "code", params = "code", spec = Like.class),
                    @Spec(path = "name", params = "name", spec = Like.class),
                    @Spec(path = "disabled", params = "disabled", spec = Equal.class),
            })
            Specification<Position> query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @PostMapping("/search")
    public JsonResult<JsonResult.PageList> pageSearch(
            @And({
                    @Spec(path = "code", jsonPaths = "code", spec = Like.class),
                    @Spec(path = "name", jsonPaths = "name", spec = Like.class),
                    @Spec(path = "disabled", jsonPaths = "disabled", spec = Equal.class),
            })
            Specification<Position> query, Pageable pageable) {
        return super.page(query, pageable);
    }

    @PostMapping
    public JsonResult<String> create(@RequestBody PositionParam param) {
        param.setJobProfile(new Dict("开发工程师"));
        return super.create(param);
    }

    @PutMapping("/{id}")
    public JsonResult<String> update(@PathVariable Long id, @RequestBody PositionParam param) {
        return super.update(id, param);
    }

    @DeleteMapping("/{id}")
    public JsonResult<String> delete(@PathVariable Long id) {
        return super.delete(id);
    }

    final PositionMapper mapper;

    @GetMapping("test")
    public void test() {
        PositionParam param = new PositionParam();
        param.setId(1L);
        param.setName("test");
        Position position = new Position();
        position.setId(2L);
        position.setName("position");
        mapper.paramToEntity(param, position);
        System.out.println(position.getId());
    }
}
