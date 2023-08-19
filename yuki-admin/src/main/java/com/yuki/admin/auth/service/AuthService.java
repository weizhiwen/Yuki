package com.yuki.admin.auth.service;

import com.yuki.admin.auth.dao.SystemUser;
import com.yuki.admin.auth.web.LoginParam;
import com.yuki.common.core.exception.UserPasswordNotMatchException;
import com.yuki.framework.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public String login(LoginParam param) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(param.getLoginName(), param.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            SystemUser systemUser = (SystemUser) authentication.getPrincipal();
            return tokenService.createToken(systemUser.buildUserSession());
        } catch (BadCredentialsException ex) {
            throw (UserPasswordNotMatchException) new UserPasswordNotMatchException().initCause(ex);
        }
    }

    public SystemUser getInfo() {
        return null;
    }
}
