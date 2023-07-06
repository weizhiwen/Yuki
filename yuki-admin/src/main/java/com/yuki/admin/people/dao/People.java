package com.yuki.admin.people.dao;

import com.yuki.common.constant.Constants;
import com.yuki.common.core.domain.entity.BaseEntity;
import com.yuki.admin.auth.dao.SystemUser;
import com.yuki.admin.department.dao.Department;
import com.yuki.admin.position.dao.Position;

import javax.persistence.*;

@Entity
@Table(name = "PEOPLE")
public class People extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "NAME", length = Constants.MEDIUM_STRING_LENGTH)
    private String name;

    @Column(name = "EMAIL", length = Constants.MEDIUM_STRING_LENGTH)
    private String email;

    @Column(name = "TEL", length = Constants.SHORT_STRING_LENGTH)
    private String tel;

    @Enumerated(EnumType.STRING)
    @Column(name = "SEX", length = Constants.MINI_STRING_LENGTH)
    private SexEnum sex;

    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "ID")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "POSITION_ID", referencedColumnName = "ID")
    private Position position;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private SystemUser user;

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public SystemUser getUser() {
        return user;
    }

    public void setUser(SystemUser user) {
        this.user = user;
    }
}
