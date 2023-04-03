package com.ruoyi.common.core.domain.entity;

import com.ruoyi.common.core.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class SystemUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "USER_NAME", length = 32)
    private String userName;

    @Column(name = "NICK_NAME", length = 32)
    private String nickName;

    @Column(name = "EMAIL", length = 32)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 11)
    private String phoneNumber;

    @Column(name = "AVATAR", length = 256)
    private String avatar;

    @Column(name = "PASSWORD", length = 64)
    private String password;

    @Column(name = "IS_ENABLED")
    private boolean enabled;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
