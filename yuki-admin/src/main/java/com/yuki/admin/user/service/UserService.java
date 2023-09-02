package com.yuki.admin.user.service;

import com.yuki.admin.user.dao.User;
import com.yuki.admin.user.dao.UserRepo;
import com.yuki.admin.user.web.UserLoginParam;
import com.yuki.admin.user.web.UserVO;
import com.yuki.common.core.exception.UserPasswordNotMatchException;
import com.yuki.common.core.service.BaseBusinessService;
import com.yuki.framework.security.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService extends BaseBusinessService<CreateUserParam, UpdateUserParam, User, UserVO> {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserRepo repo;
    private final UserMapper mapper;

    @Override
    protected UserRepo getRepo() {
        return repo;
    }

    @Override
    protected UserMapper getMapper() {
        return mapper;
    }

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
