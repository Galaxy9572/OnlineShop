package org.ljy.service;

import org.ljy.common.Page;
import org.ljy.domain.Shop;
import org.ljy.domain.ShopExample;

import java.util.List;

public interface ShopService {
    long countByExample(ShopExample example);

    int deleteByExample(ShopExample example);

    int deleteByPrimaryKey(Long shopId);

    int insert(Shop record);

    int insertSelective(Shop record);

    List<Shop> selectByExampleWithBLOBs(ShopExample example);

    List<Shop> selectByExample(ShopExample example);

    List<Shop> selectByExampleWithBLOBsByPage(ShopExample example, Page page);

    List<Shop> selectByExampleByPage(ShopExample example,Page page);

    Shop selectByPrimaryKey(Long shopId);

    int updateByExampleSelective(Shop record, ShopExample example);

    int updateByExampleWithBLOBs(Shop record, ShopExample example);

    int updateByExample(Shop record, ShopExample example);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKeyWithBLOBs(Shop record);

    int updateByPrimaryKey(Shop record);
}
