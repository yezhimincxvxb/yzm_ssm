package com.yzm4.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private Integer id;

    private String username;

    private String realName;

    private String password;

    private String gender;

    private String remark;

    private Boolean state;

    private Boolean deleted;

    private Date createDate;

    private String updateDate;

    private static final long serialVersionUID = 1L;

    public User(Integer id, String username, String realName, String password, String gender, String remark, Boolean state, Boolean deleted, Date createDate, String updateDate) {
        this.id = id;
        this.username = username;
        this.realName = realName;
        this.password = password;
        this.gender = gender;
        this.remark = remark;
        this.state = state;
        this.deleted = deleted;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }
}