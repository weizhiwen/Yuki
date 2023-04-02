package com.yuki.admin.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.JsonResult;
import com.ruoyi.common.core.service.BaseService;
import com.yuki.admin.param.LoginParam;
import com.yuki.admin.reader.UserInfoReader;
import com.yuki.admin.service.AuthService;
import com.yuki.admin.vo.UserInfoVO;
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

    @GetMapping("/info")
    public JsonResult<UserInfoVO> info() {
        service.executeWithReader(userInfoReader, () -> service.getInfo());
        return JsonResult.success(userInfoReader.fetchTarget());
    }
}
