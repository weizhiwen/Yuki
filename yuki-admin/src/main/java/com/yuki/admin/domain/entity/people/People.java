package com.yuki.admin.domain.entity.people;

import com.ruoyi.common.core.domain.entity.BaseEntity;
import com.yuki.admin.domain.entity.common.enums.SexEnum;
import com.yuki.admin.domain.entity.user.User;

import javax.persistence.*;

@Entity
public class People extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "TEL")
    private String tel;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEX")
    private SexEnum sex;

    @Column(name = "DEPARTMENT_NO")
    private String departmentNo;

    @Column(name = "POSITION_NO")
    private String positionNo;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;

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

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getPositionNo() {
        return positionNo;
    }

    public void setPositionNo(String positionNo) {
        this.positionNo = positionNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
