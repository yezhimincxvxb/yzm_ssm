package com.yzm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private String[] courses;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;

    private List<Course> courseList;
}
