package com.yzm4.entity;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    private Integer id;

    private Integer userId;

    private String username;

    private String payPassword;

    private Double totalMoney;

    private Double availableMoney;

    private Double frozenMoney;

    private Integer version;

    private Date createDate;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public Account(Integer id, Integer userId, String username, String payPassword, Double totalMoney, Double availableMoney, Double frozenMoney, Integer version, Date createDate, Date updateDate) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.payPassword = payPassword;
        this.totalMoney = totalMoney;
        this.availableMoney = availableMoney;
        this.frozenMoney = frozenMoney;
        this.version = version;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public Account() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword == null ? null : payPassword.trim();
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Double getAvailableMoney() {
        return availableMoney;
    }

    public void setAvailableMoney(Double availableMoney) {
        this.availableMoney = availableMoney;
    }

    public Double getFrozenMoney() {
        return frozenMoney;
    }

    public void setFrozenMoney(Double frozenMoney) {
        this.frozenMoney = frozenMoney;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}