package org.ljy.dao;

import org.apache.ibatis.annotations.Param;
import org.ljy.common.Page;
import org.ljy.domain.Shop;
import org.ljy.domain.ShopExample;

import java.util.List;

public interface ShopMapper {

	long countByExample(ShopExample example);

	int deleteByExample(ShopExample example);

	int deleteByPrimaryKey(Long shopId);

	int insert(Shop record);

	int insertSelective(Shop record);

	List<Shop> selectByExampleWithBLOBs(ShopExample example);

	List<Shop> selectByExample(ShopExample example);

	List<Shop> selectByExampleWithBLOBsByPage(@Param("example") ShopExample example, @Param("page")Page page);

	List<Shop> selectByExampleByPage(@Param("example") ShopExample example,@Param("page") Page page);

	Shop selectByPrimaryKey(Long shopId);

	int updateByExampleSelective(@Param("record") Shop record, @Param("example") ShopExample example);

	int updateByExampleWithBLOBs(@Param("record") Shop record, @Param("example") ShopExample example);

	int updateByExample(@Param("record") Shop record, @Param("example") ShopExample example);

	int updateByPrimaryKeySelective(Shop record);

	int updateByPrimaryKeyWithBLOBs(Shop record);

	int updateByPrimaryKey(Shop record);
}