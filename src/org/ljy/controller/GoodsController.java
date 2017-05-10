package org.ljy.controller;

import org.ljy.common.MsgConstants;
import org.ljy.common.PagedResult;
import org.ljy.domain.Goods;
import org.ljy.service.GoodsService;
import org.ljy.util.AjaxUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class GoodsController extends BaseController{
    @Resource
    private GoodsService goodsService;

    @RequestMapping("/goods/addGoods")
    @ResponseBody
    public Map<String,String> addGoods(Goods goods){
        Map<String,String> ajaxMap = null;
        if(goods != null){
            boolean flag = goodsService.addGoods(goods);
            if(flag){
                ajaxMap = AjaxUtil.generateResponseAjax("1",MsgConstants.OPERATE_SUCCESS);
            }
        }else{
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.OPERATE_FAILURE);
        }
        return ajaxMap;
    }

    @RequestMapping("/goods/deleteGoodsById")
    @ResponseBody
    public Map<String,String> deleteGoodsById(HttpServletRequest request,Long goodsId){
        Map<String,String> ajaxMap = null;
        if(goodsId > 0){
            boolean flag = goodsService.deleteGoodsById(goodsId);
            if(flag){
                ajaxMap = AjaxUtil.generateResponseAjax("1",MsgConstants.OPERATE_SUCCESS);
            }
        }else{
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.OPERATE_FAILURE);
        }
        return ajaxMap;
    }

    @RequestMapping("/goods/updateGoods")
    @ResponseBody
    public Map<String,String> updateGoods(HttpServletRequest request,Goods goods){
        Map<String,String> ajaxMap = null;
        if(goods != null){
            boolean flag = goodsService.updateGoods(goods);
            if(flag){
                ajaxMap = AjaxUtil.generateResponseAjax("1",MsgConstants.OPERATE_SUCCESS);
            }
        }else{
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.OPERATE_FAILURE);
        }
        return ajaxMap;
    }

    @RequestMapping("/goods/queryGoodsByCondition")
    @ResponseBody
    public String queryGoodsByCondition(HttpServletRequest request,String goodsType,String goodsName,Integer pageNumber, Integer pageSize){
        PagedResult result;
        try {
            if (StringUtil.isNotNullAndNotEmpty(goodsType)) {
                result = goodsService.queryGoodsByPage(goodsType, goodsName, pageNumber, pageSize);
                return responseSuccess(result);
            }else{
                return responseFail(MsgConstants.WRONG_PARAMETERS);
            }
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return responseFail(MsgConstants.SYSTEM_ERROR);
        }
    }
}
