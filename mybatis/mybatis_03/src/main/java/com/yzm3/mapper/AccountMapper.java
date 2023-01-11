package com.yzm3.mapper;

import com.yzm3.entity.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AccountMapper {

    List<Account> listAccountByIf(@Param("account") Account account);

    List<Account> listAccountByWhere(@Param("account") Account account);

    int updateBySet(@Param("account") Account account);

    List<Account> listAccountByChoose(@Param("account") Account account);

    List<Account> listAccountByForeach(@Param("ids") List<Integer> ids);

    List<Account> listAccountByBind(@Param("name") String name);

    List<Account> listUserByLike(@Param("name") String name);

    List<Account> listUserByCONCAT(@Param("name") String name);

    List<Account> listByInstr(@Param("name") String name);

    List<Account> listAccountBySQL(@Param("account") Account account);

}
