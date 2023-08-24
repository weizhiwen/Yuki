package com.yuki.admin.user.dao;

import com.yuki.common.constant.Constants;
import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serial;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER_LOGIN_LOG")
public class UserLoginLog extends BaseEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "LOGIN_NAME", length = Constants.MEDIUM_STRING_LENGTH)
    private String loginName;

    @Column(name = "IS_LOGIN_SUCCESS")
    private boolean loginSuccess;

    @Column(name = "IP_ADDRESS", length = Constants.MEDIUM_STRING_LENGTH)
    private String ipAddress;

    @Column(name = "IP_LOCATION")
    private String ipLocation;

    @Column(name = "BROWSER", length = Constants.MEDIUM_STRING_LENGTH)
    private String browser;

    @Column(name = "OS", length = Constants.MEDIUM_STRING_LENGTH)
    private String os;

    @Column(name = "LOGIN_TIME")
    private LocalDateTime loginTime;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
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
