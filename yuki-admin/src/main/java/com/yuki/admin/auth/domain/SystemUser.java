package com.yuki.admin.auth.domain;

import com.yuki.common.core.domain.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "SYSTEM_USER")
public class SystemUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Column(name = "USERNAME", length = 32, unique = true)
    private String username;

    @Column(name = "NICKNAME", length = 32)
    private String nickname;

    @Column(name = "EMAIL", length = 32)
    private String email;

    @Column(name = "TEL", length = 11)
    private String tel;

    @Column(name = "AVATAR", length = 256)
    private String avatar;

    @Column(name = "PASSWORD", length = 64, nullable = false)
    private String password;

    @Column(name = "IS_ENABLED")
    private boolean enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
