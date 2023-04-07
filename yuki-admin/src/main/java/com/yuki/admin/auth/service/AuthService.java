package com.yuki.admin.auth.service;

import com.ruoyi.common.core.domain.model.UserLogin;
import com.ruoyi.common.core.service.BaseService;
import com.yuki.admin.auth.controller.LoginParam;
import com.yuki.admin.auth.domain.SystemUser;
import com.yuki.framework.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AuthService extends BaseService<SystemUser> {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public String login(LoginParam param) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(param.getUsername(), param.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            UserLogin userLogin = (UserLogin) authentication.getPrincipal();
            return tokenService.createToken(userLogin);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public SystemUser getInfo() {
        return null;
    }
}
