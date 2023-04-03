package com.yuki.framework.security;

import com.ruoyi.common.core.domain.JsonResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.util.ServletUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;

@EnableWebSecurity
public class SecurityConfig {
    @Resource
    private TokenAuthenticationService tokenAuthenticationService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests((auth) -> auth.anyRequest().authenticated()).build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resources/**");
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (request, response, authentication) -> ServletUtils.renderJson(response, JsonResult.unauthorized());
    }

    @Bean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return (request, response, authentication)->{
            LoginUser loginUser = tokenAuthenticationService.getLoginUser(request);
            if (loginUser != null) {
                tokenAuthenticationService.deleteLoginUser(loginUser);
                // TODO 记录日志
            }
            ServletUtils.renderJson(response, JsonResult.success("退出成功"));
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
