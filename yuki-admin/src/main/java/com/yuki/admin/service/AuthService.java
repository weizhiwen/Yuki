package com.yuki.admin.service;

import com.ruoyi.common.core.service.BaseService;
import com.yuki.admin.domain.entity.user.User;
import com.yuki.admin.param.LoginParam;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends BaseService<User> {
    public String login(LoginParam param) {
        return null;
    }

    public User getInfo() {
        return null;
    }
}
