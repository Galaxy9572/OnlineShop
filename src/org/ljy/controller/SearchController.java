package org.ljy.controller;

import org.apache.log4j.Logger;
import org.ljy.domain.*;
import org.ljy.service.GoodsService;
import org.ljy.service.ShopService;
import org.ljy.service.UserService;
import org.ljy.util.AjaxUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class SearchController{
	private static Logger LOG = Logger.getLogger(SearchController.class);

	@Resource
	private UserService userService;

	@Resource
	private ShopService shopService;

	@Resource
	private GoodsService goodsService;

	/**
	 * 返回搜索结果页面
	 * @return 搜索结果页面
	 */
	@RequestMapping("/search/searchResult")
	public String searchResultPage(){
		return "search/searchResult";
	}

	@RequestMapping(value = "/search", method= RequestMethod.GET)
    @ResponseBody
	public String search(HttpServletRequest request, String keyWord, String type){
	    Map<String,String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
		boolean bool = StringUtil.isEmpty(keyWord) && StringUtil.isEmpty(type);
        if(!bool){//非空
        	int typeInt = Integer.parseInt(type);
        	switch (typeInt){
				case 1://用户
					UserExample userExample = new UserExample();
					userExample.or().andUserNameLike("%"+keyWord+"%");
					List<User> users = userService.selectByExample(userExample);
					request.setAttribute("userSearchResult",users);
					break;
				case 2://商品
                    GoodsExample goodsExample = new GoodsExample();
				    goodsExample.or().andGoodsNameLike("%"+keyWord+"%");
                    List<Goods> goods = goodsService.selectByExample(goodsExample);
                    request.setAttribute("goodsSearchResult",goods);
                    break;
                case 3://商家
                    ShopExample shopExample = new ShopExample();
                    shopExample.or().andShopNameLike("%"+keyWord+"%");
                    List<Shop> shops = shopService.selectByExample(shopExample);
                    request.setAttribute("shopSearchResult",shops);
                    break;
				default:
				    ajaxMap.put("status","0");
				    return searchResultPage();
            }
        }else{
            request.setAttribute("searchResult",null);
            ajaxMap.put("status","0");
        }
		return searchResultPage();
	}
}
