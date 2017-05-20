package org.ljy.service;

import org.ljy.common.PagedResult;
import org.ljy.domain.Shop;
import org.ljy.domain.ShopExample;
import org.ljy.domain.User;

public interface ShopService {
    long countByExample(ShopExample example);

    boolean checkIfCanOpen(User user,Shop shop);

    Shop openShop(User user, Shop shop);

    Shop getShop(ShopExample example);

    Shop getShopByShopId(Long shopId);

    PagedResult selectByExampleWithBLOBsByPage(ShopExample example, Integer pageNo, Integer pageSize);

    PagedResult selectByExampleByPage(ShopExample example,Integer pageNo, Integer pageSize);

}
