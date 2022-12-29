package com.yzm4.service;

public class AccountService {

    public String transfer(String fromUser, String toUser) {
        System.out.println(fromUser + "转账给" + toUser + "100元");
        return "转账完成";
    }

}
