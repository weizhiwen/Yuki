package com.yuki.admin.auth.web;

import com.yuki.admin.auth.service.AuthService;
import com.yuki.admin.auth.service.UserInfoReader;
import com.yuki.common.core.domain.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Resource
    private AuthService service;
    @Resource
    private UserInfoReader userInfoReader;

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
        userInfoReader.read(service.getInfo());
        return JsonResult.success(userInfoReader.fetchTarget());
    }
}
