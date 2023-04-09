package com.yuki.framework.security;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.yuki.common.constant.CacheConstants;
import com.yuki.common.constant.Constants;
import com.yuki.common.core.domain.model.UserSession;
import com.yuki.common.core.repo.RedisRepo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class TokenService {
    final TokenProperty tokenProperty;
    final UserDetailsService userDetailsService;
    final RedisRepo redisRepo;

    public UserSession getUserSession(HttpServletRequest request) {
        String token = getToken(request);
        if (StrUtil.isNotEmpty(token)) {
            try {
                Claims claims = parseToken(token);
                String sessionId = (String) claims.get(Constants.LOGIN_SESSION_ID);
                String userSessionKey = getUserSessionKey(sessionId);
                return (UserSession) redisRepo.get(userSessionKey);
            } catch (SignatureException e) {
                log.error("JWT签名不匹配，无效的JWT");
            }
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

    public void refreshTokenIfNecessary(UserSession userSession) {
        LocalDateTime expireTime = userSession.getExpireTime();
        LocalDateTime now = LocalDateTime.now();
        if (expireTime.isBefore(now)) {
            refreshToken(userSession);
        }
    }

    private Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(tokenProperty.getSecret())
                .parseClaimsJws(token)
                .getBody();
    }

    public void deleteUserSession(UserSession userSession) {
        redisRepo.del(getUserSessionKey(userSession.getSessionId()));
    }

    public String createToken(UserSession userSession) {
        String username = userSession.getUsername();
        userSession.setSessionId(username);
        String sessionId = IdUtil.fastSimpleUUID();
        userSession.setSessionId(sessionId);
        refreshToken(userSession);
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constants.LOGIN_USER_NAME, username);
        claims.put(Constants.LOGIN_SESSION_ID, sessionId);
        return createTokenByClaims(claims);
    }

    private String createTokenByClaims(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.forName(tokenProperty.getAlgorithm()), tokenProperty.getSecret()).compact();
    }

    public void refreshToken(UserSession userSession) {
        userSession.setLoginTime(LocalDateTime.now());
        redisRepo.set(getUserSessionKey(userSession.getSessionId()), userSession, tokenProperty.getExpireTime(), TimeUnit.MINUTES);
        userSession.setExpireTime(userSession.getLoginTime().plus(tokenProperty.getExpireTime(), ChronoUnit.MINUTES));
    }

    private String getUserSessionKey(@NonNull String sessionId) {
        return CacheConstants.LOGIN_SESSION + sessionId;
    }
}
