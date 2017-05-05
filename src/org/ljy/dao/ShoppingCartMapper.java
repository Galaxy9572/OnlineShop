package org.ljy.dao;

import org.apache.ibatis.annotations.Param;
import org.ljy.domain.ShoppingCart;
import org.ljy.domain.ShoppingCartExample;

import java.util.List;

public interface ShoppingCartMapper {

	long countByExample(ShoppingCartExample example);

	int deleteByExample(ShoppingCartExample example);

	int deleteByPrimaryKey(Long cartId);

	int insert(ShoppingCart record);

	int insertSelective(ShoppingCart record);

	List<ShoppingCart> selectByExample(ShoppingCartExample example);

	ShoppingCart selectByPrimaryKey(Long cartId);

	int updateByExampleSelective(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

	int updateByExample(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

	int updateByPrimaryKeySelective(ShoppingCart record);

	int updateByPrimaryKey(ShoppingCart record);
}