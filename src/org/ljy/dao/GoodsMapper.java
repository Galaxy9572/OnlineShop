package org.ljy.dao;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.ljy.domain.Goods;
import org.ljy.domain.GoodsExample;

import java.util.List;

public interface GoodsMapper {

	long countByExample(GoodsExample example);

	int deleteByExample(GoodsExample example);

	int deleteByPrimaryKey(Long goodsId);

	int insert(Goods record);

	int insertSelective(Goods record);

	List<Goods> selectByExampleWithBLOBs(GoodsExample example);

	List<Goods> selectByExample(GoodsExample example);

    List<Goods> selectByExampleWithBLOBsByPage(@Param("example") GoodsExample example, @Param("page")Page page);

    List<Goods> selectByExampleByPage(@Param("example") GoodsExample example, @Param("page")Page page);

	Goods selectByPrimaryKey(Long goodsId);

	int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

	int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);

	int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKeyWithBLOBs(Goods record);

	int updateByPrimaryKey(Goods record);
}