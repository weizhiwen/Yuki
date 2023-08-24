package com.yuki.admin.user.web;

import com.yuki.admin.user.service.UserService;
import com.yuki.admin.user.service.UserBasicInfoReader;
import com.yuki.common.core.domain.JsonResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService service;
    @Resource
    private UserBasicInfoReader userBasicInfoReader;

    @PostMapping("/login")
    public JsonResult<String> login(@RequestBody UserLoginParam param) {
        return JsonResult.success(service.login(param));
    }

    @GetMapping("/test")
    public JsonResult<String> test() {
        return JsonResult.success("Success");
    }

    @GetMapping("/info")
    public JsonResult<UserBasicInfoVO> info() {
        userBasicInfoReader.read(service.getInfo());
        return JsonResult.success(userBasicInfoReader.fetchTarget());
    }
}
