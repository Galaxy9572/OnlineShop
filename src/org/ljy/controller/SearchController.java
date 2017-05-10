package org.ljy.controller;

import org.apache.log4j.Logger;
import org.ljy.service.SearchService;
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
	private SearchService searchService;

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
	    Map<String,String> ajaxMap = null;
		boolean bool = StringUtil.isNotNullAndNotEmpty(keyWord) && StringUtil.isNotNullAndNotEmpty(type);
		try {
			if(bool){//非空
                int typeInt = Integer.parseInt(type);
                switch (typeInt){
                    case 1://用户
                        List<?> users = searchService.search(keyWord,typeInt);
                        request.setAttribute("userSearchResult",users);
                        break;
                    case 2://商品
                        List<?> goods = searchService.search(keyWord,typeInt);
                        request.setAttribute("goodsSearchResult",goods);
                        break;
                    case 3://商家
                        List<?> shops = searchService.search(keyWord,typeInt);
                        request.setAttribute("shopSearchResult",shops);
                        break;
                    default:
                        ajaxMap = AjaxUtil.generateResponseAjax("0", null);
                        return searchResultPage();
                }
            }else{
                request.setAttribute("searchResult",null);
                ajaxMap = AjaxUtil.generateResponseAjax("0", null);
            }
		} catch (NumberFormatException e) {
			LOG.warn("searchService异常"+e.getMessage(),e);
            ajaxMap = AjaxUtil.generateResponseAjax("0", null);
		}
		return searchResultPage();
	}
}
