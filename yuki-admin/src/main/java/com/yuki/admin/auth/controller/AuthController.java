package com.yuki.admin.auth.controller;

import com.yuki.common.core.controller.BaseController;
import com.yuki.common.core.domain.JsonResult;
import com.yuki.common.core.service.BaseService;
import com.yuki.admin.auth.service.AuthService;
import com.yuki.admin.auth.service.UserInfoReader;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController extends BaseController {
    @Resource
    private AuthService service;
    @Resource
    private UserInfoReader userInfoReader;

    @Override
    protected BaseService getService() {
        return service;
    }

    @PostMapping("/login")
    public JsonResult<String> login(@RequestBody LoginParam param) {
        return JsonResult.success(service.login(param));
    }

    @GetMapping("/test")
    public JsonResult<String> test() {
        return JsonResult.success("Success");
    }

    @GetMapping("/info")
    public JsonResult<SystemUserInfoVO> info() {
        service.executeWithReader(userInfoReader, () -> service.getInfo());
        return JsonResult.success(userInfoReader.fetchTarget());
    }
}
