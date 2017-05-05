package org.ljy.service.impl;

import org.ljy.domain.Goods;
import org.ljy.domain.Shop;
import org.ljy.domain.User;
import org.ljy.service.SearchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("searchService")
public class SearchServiceImpl implements SearchService {

	@Override
	public List<Goods> searchGoodsByGoodsName(String goodsName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shop> searchShopByShopName(String shopName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> searchUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
