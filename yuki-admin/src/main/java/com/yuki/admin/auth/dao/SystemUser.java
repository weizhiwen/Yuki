package com.yuki.admin.auth.dao;

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
@Table(name = "SYSTEM_USER")
public class SystemUser extends BaseEntity implements UserDetails {
    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "USER_NO", length = Constants.MEDIUM_STRING_LENGTH, unique = true)
    private String userNo;

    @Column(name = "USERNAME", length = Constants.MEDIUM_STRING_LENGTH, unique = true)
    private String username;

    @Column(name = "EMAIL", length = Constants.MEDIUM_STRING_LENGTH, unique = true)
    private String email;

    @Column(name = "TEL", length = Constants.SHORT_STRING_LENGTH)
    private String tel;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "PASSWORD", length = Constants.LONG_STRING_LENGTH, nullable = false)
    private String password;

    @Column(name = "IS_ENABLED")
    private boolean enabled;

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

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
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

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserSession buildUserSession() {
        UserSession userSession = new UserSession();
        userSession.setSessionId(IdUtil.fastSimpleUUID());
        userSession.setUserNo(this.getUserNo());
        userSession.setUsername(this.getUsername());
        userSession.setAuthorities((List<GrantedAuthority>) this.getAuthorities());
        return userSession;
    }
}
