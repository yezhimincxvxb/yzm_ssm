package com.yzm4.mapper;

import com.yzm4.entity.Account;
import com.yzm4.entity.AccountCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountMapper {
    long countByExample(AccountCriteria example);

    int deleteByExample(AccountCriteria example);

    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountCriteria example);

    Account selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountCriteria example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountCriteria example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);
}