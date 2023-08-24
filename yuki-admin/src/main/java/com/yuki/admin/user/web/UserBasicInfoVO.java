package com.yuki.admin.user.web;

import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.BaseData;
import com.yuki.admin.user.dao.User;

@RelatedClass(classes = {User.class})
public class UserBasicInfoVO implements BaseData {
    private static final long serialVersionUID = 1L;

    private String username;

    private String avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
