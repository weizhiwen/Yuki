package com.yuki.admin.vo;

import com.ruoyi.common.annotation.RelatedClass;
import com.ruoyi.common.core.domain.BaseData;
import com.yuki.admin.domain.entity.user.User;

@RelatedClass(classes = {User.class})
public class UserInfoVO extends BaseData {
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
