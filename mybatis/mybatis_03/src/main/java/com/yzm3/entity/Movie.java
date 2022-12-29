package com.yzm3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie implements Serializable {

    private Integer id;
    private String name;
    private String director;
    private Double score;
    private String showDate;

}
