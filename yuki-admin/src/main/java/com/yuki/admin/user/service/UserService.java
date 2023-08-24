package com.yuki.admin.user.service;

import com.yuki.admin.user.dao.User;
import com.yuki.admin.user.web.UserLoginParam;
import com.yuki.common.core.exception.UserPasswordNotMatchException;
import com.yuki.framework.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public String login(UserLoginParam param) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(param.getLoginName(), param.getPassword());
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            User user = (User) authentication.getPrincipal();
            return tokenService.createToken(user.buildUserSession());
        } catch (BadCredentialsException ex) {
            throw (UserPasswordNotMatchException) new UserPasswordNotMatchException().initCause(ex);
        }
    }

    public User getInfo() {
        return null;
    }
}
