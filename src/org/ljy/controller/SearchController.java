package org.ljy.controller;

import org.ljy.service.SearchService;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ljy56
 */
@Controller
public class SearchController extends BaseController{
	@Resource
	private SearchService searchService;

	/**
	 * 返回搜索结果页面
	 * @return 搜索结果页面
	 */
	@RequestMapping("/search/searchResult")
	public String searchResultPage(){
		return "search/searchResult";
	}

	@RequestMapping("/search")
	public String search(HttpServletRequest request, String keyWord, String type){
		boolean bool = StringUtil.isNotNullAndNotEmpty(keyWord) && StringUtil.isNotNullAndNotEmpty(type);
		try {
			if(bool){//非空
                int typeInt = Integer.parseInt(type);
                switch (typeInt){
                    case 1://用户
                        List<?> users = searchService.search(keyWord,typeInt);
                        request.setAttribute("userSearchResult",users);
                        return "search/searchResult";
                    case 2://商品
                        List<?> goods = searchService.search(keyWord,typeInt);
                        request.setAttribute("goodsSearchResult",goods);
                        return "search/searchResult";
                    case 3://商家
                        List<?> shops = searchService.search(keyWord,typeInt);
                        request.setAttribute("shopSearchResult",shops);
                        return "search/searchResult";
                    default:
                        return "search/searchResult";
                }
            }else{
                request.setAttribute("searchResult",null);
            }
		} catch (NumberFormatException e) {
			LOG.warn("searchService异常"+e.getMessage(),e);
		}
		return "search/searchResult";
	}
}
