package org.ljy.service;

import org.apache.ibatis.annotations.Param;
import org.ljy.common.PagedResult;
import org.ljy.domain.BankCard;
import org.ljy.domain.BankCardExample;

import java.util.List;

public interface BankCardService {
    long countByExample(BankCardExample example);

    int deleteByExample(BankCardExample example);

    int deleteByPrimaryKey(Long bankCardId);

    int insert(BankCard record);

    int insertSelective(BankCard record);

    List<BankCard> selectByExample(BankCardExample example);

    PagedResult selectByExampleByPage(BankCardExample example,Integer pageNo,Integer pageSize);

    BankCard selectByPrimaryKey(Long bankCardId);

    int updateByExampleSelective(@Param("record") BankCard record, @Param("example") BankCardExample example);

    int updateByExample(@Param("record") BankCard record, @Param("example") BankCardExample example);

    int updateByPrimaryKeySelective(BankCard record);

    int updateByPrimaryKey(BankCard record);
}
