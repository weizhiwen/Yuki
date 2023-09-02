package com.yuki.admin.user.web;

import com.yuki.admin.user.dao.User;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.BaseVO;

@RelatedClass(classes = User.class)
public class UserVO extends BaseVO {
    private String username;

    private String name;

    private String email;

    private String tel;

    private String avatar;

    private boolean enabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
