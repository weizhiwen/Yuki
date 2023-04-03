package com.yuki.admin.auth.service;

import com.ruoyi.common.core.service.BaseService;
import com.yuki.admin.auth.controller.LoginParam;
import com.ruoyi.common.core.domain.entity.SystemUser;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends BaseService<SystemUser> {
    public String login(LoginParam param) {
        return null;
    }

    public SystemUser getInfo() {
        return null;
    }
}
