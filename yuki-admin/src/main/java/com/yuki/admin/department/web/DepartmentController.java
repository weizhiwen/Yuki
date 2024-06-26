package com.yuki.admin.department.web;

import com.yuki.admin.department.dao.Department;
import com.yuki.admin.department.service.*;
import com.yuki.common.core.controller.BaseBusinessController;
import com.yuki.common.core.domain.JsonResult;
import lombok.RequiredArgsConstructor;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/departments")
@RequiredArgsConstructor
@RestController
public class DepartmentController extends BaseBusinessController<DepartmentParam, DepartmentParam, Department, DepartmentVO> {
    private final DepartmentService service;
    private final DepartmentReader reader;

    @Override
    protected DepartmentService getService() {
        return service;
    }

    @Override
    protected DepartmentReader getReader() {
        return reader;
    }

    @GetMapping("/hierarchy")
    public JsonResult<HierarchyDepartmentVO> hierarchy(
            @And({
                    @Spec(path = "code", params = "code", spec = Like.class),
                    @Spec(path = "name", params = "name", spec = Like.class),
                    @Spec(path = "disabled", params = "disabled", spec = Equal.class),
            })
            Specification<Department> query) {
        return JsonResult.success(service.hierarchy(query));
    }

    @Override
    @GetMapping("/{id}")
    public JsonResult<DepartmentVO> detail(@PathVariable Long id) {
        return super.detail(id);
    }

    @Override
    @PostMapping
    public JsonResult<String> create(@RequestBody DepartmentParam param) {
        return super.create(param);
    }

    @Override
    @PutMapping("/{id}")
    public JsonResult<String> update(@PathVariable Long id, @RequestBody DepartmentParam param) {
        return super.update(id, param);
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
