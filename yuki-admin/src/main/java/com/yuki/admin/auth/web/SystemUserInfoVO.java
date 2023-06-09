package com.yuki.admin.auth.web;

import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.BaseData;
import com.yuki.admin.auth.dao.SystemUser;

@RelatedClass(classes = {SystemUser.class})
public class SystemUserInfoVO implements BaseData {
    private static final long serialVersionUID = 1L;

    private String nickname;

    private String avatar;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
