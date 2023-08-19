package com.yuki.framework.security;

import cn.hutool.core.text.CharSequenceUtil;
import com.yuki.common.constant.CacheConstants;
import com.yuki.common.constant.Constants;
import com.yuki.common.core.dao.RedisRepo;
import com.yuki.common.core.domain.model.UserSession;
import io.jsonwebtoken.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenService {
    private final TokenProperty tokenProperty;
    private final RedisRepo redisRepo;

    public UserSession getUserSession(HttpServletRequest request) {
        String token = getToken(request);
        if (CharSequenceUtil.isEmpty(token)) {
            return null;
        }
        try {
            Claims claims = parseToken(token);
            String sessionId = (String) claims.get(Constants.LOGIN_SESSION_ID);
            String userSessionKey = getUserSessionKey(sessionId);
            return redisRepo.get(userSessionKey, UserSession.class);
        } catch (JwtException e) {
            throw new JwtException("JWT签名不匹配，无效的JWT");
        }
    }

    public String getToken(HttpServletRequest request) {
        String header = request.getHeader(tokenProperty.getHeader());
        if (CharSequenceUtil.isEmpty(header) || !header.startsWith(Constants.TOKEN_PREFIX)) {
            return null;
        }
        return header.substring(Constants.TOKEN_PREFIX.length());
    }

    public void refreshTokenIfNecessary(UserSession userSession) {
        LocalDateTime expireTime = userSession.getExpireTime();
        LocalDateTime now = LocalDateTime.now();
        if (expireTime.isAfter(now)) {
            refreshToken(userSession);
        }
    }

    private Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(tokenProperty.getSecret()).parseClaimsJws(token).getBody();
    }

    public void deleteUserSession(UserSession userSession) {
        redisRepo.del(getUserSessionKey(userSession.getSessionId()));
    }

    public String createToken(UserSession userSession) {
        refreshToken(userSession);
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_NAME, userSession.getUsername());
        claims.put(Constants.LOGIN_SESSION_ID, userSession.getSessionId());
        return createTokenByClaims(claims);
    }

    private String createTokenByClaims(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.forName(tokenProperty.getAlgorithm()), tokenProperty.getSecret()).compact();
    }

    public void refreshToken(UserSession userSession) {
        userSession.setLoginTime(LocalDateTime.now());
        userSession.setExpireTime(userSession.getLoginTime().plusMinutes(tokenProperty.getExpireTime()));
        redisRepo.set(getUserSessionKey(userSession.getSessionId()), userSession, tokenProperty.getExpireTime(), TimeUnit.MINUTES);
    }

    private String getUserSessionKey(@NonNull String sessionId) {
        return CacheConstants.LOGIN_SESSION + sessionId;
    }
}
