package com.yzm3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserOne {

    private Integer id;
    private String username;
    private String realName;
    private String gender;
    private String remark;
    private Date createDate;

    // 一对一，一个用户对于一个账户
    private Account account;
}
