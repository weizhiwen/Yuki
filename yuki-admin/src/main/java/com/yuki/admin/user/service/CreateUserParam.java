package com.yuki.admin.user.service;

import com.yuki.admin.user.dao.User;
import com.yuki.common.annotation.RelatedClass;
import com.yuki.common.core.domain.CreateParam;

@RelatedClass(classes = User.class)
public class CreateUserParam extends CreateParam {
    private String username;

    private String name;

    private String email;

    private String tel;

    private String password;


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
