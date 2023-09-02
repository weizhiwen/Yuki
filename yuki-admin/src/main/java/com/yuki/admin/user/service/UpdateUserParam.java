package com.yuki.admin.user.service;

import com.yuki.admin.user.dao.User;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.UpdateParam;

@RelatedClass(classes = User.class)
public class UpdateUserParam extends UpdateParam {
    private String name;

    private String email;

    private String tel;

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
}
