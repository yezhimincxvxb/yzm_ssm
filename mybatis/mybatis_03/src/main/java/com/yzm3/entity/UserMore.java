package com.yzm3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserMore {

    private Integer id;
    private String username;
    private String realName;
    private String gender;
    private String remark;

    // 一对多
    private List<Movie> movies;
}
