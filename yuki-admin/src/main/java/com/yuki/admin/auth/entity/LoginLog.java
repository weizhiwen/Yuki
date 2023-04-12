package com.yuki.admin.auth.entity;

import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class LoginLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "USERNAME", length = 32)
    private String username;

    @Column(name = "IS_LOGIN_SUCCESS")
    private boolean loginSuccess;

    @Column(name = "IP_ADDRESS", length = 32)
    private String ipAddress;

    @Column(name = "IP_LOCATION", length = 256)
    private String ipLocation;

    @Column(name = "BROWSER", length = 32)
    private String browser;

    @Column(name = "OS", length = 32)
    private String os;

    @Column(name = "LOGIN_TIME")
    private LocalDateTime loginTime;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpLocation() {
        return ipLocation;
    }

    public void setIpLocation(String ipLocation) {
        this.ipLocation = ipLocation;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }
}
