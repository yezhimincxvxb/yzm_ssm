package com.yzm.entity;

import lombok.Data;

@Data
public class Employee {

    private String name;
    private String sex;

    private Department department;
}
