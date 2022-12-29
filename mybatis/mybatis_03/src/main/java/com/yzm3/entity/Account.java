package com.yzm3.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Integer id;
    private String userId;
    private String username;
    private String payPassword;
    private BigDecimal totalMoney;
    private BigDecimal availableMoney;
    private BigDecimal frozenMoney;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
