package com.yuki.admin.auth.web;

import com.yuki.common.core.domain.BaseParam;

import java.io.Serial;


public class LoginParam extends BaseParam {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 用户名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;

    /**
     * 验证码
     */
    private String captchaCode;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }
}
