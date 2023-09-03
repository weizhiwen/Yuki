package com.yuki.admin.user.dao;

import cn.hutool.core.util.IdUtil;
import com.yuki.common.constant.Constants;
import com.yuki.common.core.domain.entity.BaseEntity;
import com.yuki.common.core.domain.model.UserSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serial;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "USER")
public class User extends BaseEntity implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    // 登录名
    @Column(name = "USERNAME", nullable = false, length = Constants.MEDIUM_STRING_LENGTH, unique = true)
    private String username;

    // 用户名称
    @Column(name = "NAME", length = Constants.MEDIUM_STRING_LENGTH, nullable = false)
    private String name;

    @Column(name = "EMAIL", length = Constants.MEDIUM_STRING_LENGTH, unique = true)
    private String email;

    @Column(name = "TEL", length = Constants.SHORT_STRING_LENGTH)
    private String tel;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "PASSWORD", length = Constants.LONG_STRING_LENGTH, nullable = false)
    private String password;

    @Column(name = "IS_ENABLED")
    private Boolean enabled = Boolean.TRUE;

    @Transient
    private List<GrantedAuthority> authorities;


    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
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

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserSession buildUserSession() {
        UserSession userSession = new UserSession();
        userSession.setSessionId(IdUtil.fastSimpleUUID());
        userSession.setUsername(this.getUsername());
        userSession.setAuthorities((List<GrantedAuthority>) this.getAuthorities());
        return userSession;
    }
}
