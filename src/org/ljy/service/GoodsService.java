package org.ljy.service;

import org.ljy.common.Page;
import org.ljy.domain.Goods;
import org.ljy.domain.GoodsExample;

import java.util.List;

public interface GoodsService {
    long countByExample(GoodsExample example);

    int deleteByExample(GoodsExample example);

    int deleteByPrimaryKey(Long goodsId);

    int insert(Goods record);

    int insertSelective(Goods record);

    List<Goods> selectByExampleWithBLOBs(GoodsExample example);

    List<Goods> selectByExample(GoodsExample example);

    List<Goods> selectByExampleWithBLOBsByPage(GoodsExample example,Page page);

    List<Goods> selectByExampleByPage(GoodsExample example,Page page);

    Goods selectByPrimaryKey(Long goodsId);

    int updateByExampleSelective(Goods record, GoodsExample example);

    int updateByExampleWithBLOBs(Goods record, GoodsExample example);

    int updateByExample(Goods record, GoodsExample example);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);
}

