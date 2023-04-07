package com.yuki.framework.security;

import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.model.UserLogin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class TokenService {
    final TokenProperty tokenProperty;
    final UserDetailsService userDetailsService;


    public UserLogin getLoginUser(HttpServletRequest request) {
        String token = getToken(request);
        if (StrUtil.isNotEmpty(token)) {
            Claims claims = parseToken(token);
            String userName = (String) claims.get(Constants.LOGIN_USER_KEY);
            return (UserLogin) userDetailsService.loadUserByUsername(userName);
        }
        return null;
    }

    public String getToken(HttpServletRequest request) {
        String header = request.getHeader(tokenProperty.getHeader());
        if (StrUtil.isNotEmpty(header) && header.startsWith(Constants.TOKEN_PREFIX)) {
            return header.substring(Constants.TOKEN_PREFIX.length());
        }
        return null;
    }

    public void verifyTokenExpire(UserLogin userLogin) {
        return;
    }

    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(tokenProperty.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }

    public void deleteLoginUser(UserLogin userLogin) {

    }

    public String createToken(UserLogin userLogin) {
        String userKey = userLogin.getUsername();
        userLogin.setUserKey(userKey);
        refreshToken(userLogin);
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_KEY, userKey);
        return createTokenByClaims(claims);
    }

    private String createTokenByClaims(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, tokenProperty.getSecret()).compact();
    }

    public void refreshToken(UserLogin userLogin) {
        userLogin.setLoginTime(LocalDateTime.now());
        userLogin.setExpireTime(userLogin.getLoginTime().plus(tokenProperty.getExpireTime(), ChronoUnit.MINUTES));
    }
}
