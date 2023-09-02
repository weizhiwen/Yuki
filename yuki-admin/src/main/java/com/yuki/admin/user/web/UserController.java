package com.yuki.admin.user.web;

import com.yuki.admin.user.dao.User;
import com.yuki.admin.user.service.*;
import com.yuki.common.core.controller.BaseBusinessController;
import com.yuki.common.core.domain.JsonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController extends BaseBusinessController<CreateUserParam, UpdateUserParam, User, UserVO> {
    private final UserService service;
    private final UserBasicInfoReader userBasicInfoReader;
    private final UserReader reader;

    @Override
    protected UserService getService() {
        return service;
    }

    @Override
    protected UserReader getReader() {
        return reader;
    }

    @PostMapping("/login")
    public JsonResult<String> login(@RequestBody UserLoginParam param) {
        return JsonResult.success(service.login(param));
    }

    @GetMapping("/test")
    public JsonResult<String> test() {
        return JsonResult.success("Success");
    }

    @PostMapping
    public JsonResult<String> create(@RequestBody CreateUserParam param) {
        return super.create(param);
    }

    @PutMapping("/{id}")
    public JsonResult<String> update(@PathVariable Long id, @RequestBody UpdateUserParam param) {
        return super.update(id, param);
    }

    @Override
    @GetMapping("/{id}")
    public JsonResult<UserVO> detail(@PathVariable Long id) {
        return super.detail(id);
    }

    @GetMapping("/info")
    public JsonResult<UserBasicInfoVO> info() {
        userBasicInfoReader.read(service.getInfo());
        return JsonResult.success(userBasicInfoReader.fetchTarget());
    }
}
