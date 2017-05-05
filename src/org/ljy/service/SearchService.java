package org.ljy.service;

import org.ljy.domain.Goods;
import org.ljy.domain.Shop;
import org.ljy.domain.User;

import java.util.List;

public interface SearchService {
	/**
	 * 按商品名搜索商品
	 * @param goodsName
	 * @return List<Goods>
	 */
    List<Goods> searchGoodsByGoodsName(String goodsName);
	
	/**
	 * 按商店名搜索商店
	 * @param shopName
	 * @return List<Shop>
	 */
    List<Shop> searchShopByShopName(String shopName);
	
	/**
	 * 根据用户名搜索用户
	 * @param userName
	 * @return List<User>
	 */
    List<User> searchUserByUserName(String userName);
}
