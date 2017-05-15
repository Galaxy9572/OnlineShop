package org.ljy.service;

import org.ljy.common.PagedResult;
import org.ljy.domain.Goods;
import org.ljy.domain.GoodsExample;

public interface GoodsService {
    long countByExample(GoodsExample example);

    boolean addGoods(Goods goods);

    boolean deleteGoodsById(Long goodsId);

    boolean updateGoods(Goods goods);

    PagedResult queryGoodsByPage(String goodsType,String goodsName ,Integer pageNumber,Integer pageSize);
}

