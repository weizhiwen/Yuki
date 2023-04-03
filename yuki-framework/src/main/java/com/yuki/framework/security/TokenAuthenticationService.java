package com.yuki.framework.security;

import com.ruoyi.common.core.domain.model.LoginUser;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenAuthenticationService {

    public LoginUser getLoginUser(HttpServletRequest request) {
        return null;
    }

    public void verifyTokenExpire(LoginUser loginUser) {
        
    }

    public void deleteLoginUser(LoginUser loginUser) {

    }
}
