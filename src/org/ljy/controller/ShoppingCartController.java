package org.ljy.controller;

import org.ljy.common.MsgConstants;
import org.ljy.common.PagedResult;
import org.ljy.domain.ShoppingCart;
import org.ljy.service.ShoppingCartService;
import org.ljy.util.AjaxUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by ljy56 on 2017/4/13.
 */
@Controller
public class ShoppingCartController extends BaseController{
    @Resource
    private ShoppingCartService shoppingCartService;

    /**
     * 添加到购物车
     * @param request HttpServletRequest
     * @param shoppingCart ShoppingCart
     * @return ajaxMap
     */
    @RequestMapping("/shoppingCart/addToCart")
    @ResponseBody
    public Map<String,String> addToCart(HttpServletRequest request, ShoppingCart shoppingCart){
        Map<String,String> ajaxMap;
        try {
            boolean bool = shoppingCartService.addToCart(shoppingCart);
            if(bool){
                ajaxMap = AjaxUtil.generateResponseAjax("1", MsgConstants.OPERATE_SUCCESS);
            }else{
                ajaxMap = AjaxUtil.generateResponseAjax("0", MsgConstants.OPERATE_FAILURE);
            }
            return ajaxMap;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            return ajaxMap;
        }
    }

    /**
     * 移除购物车
     * @param request HttpServletRequest
     * @param cartId cartId
     * @return ajaxMap
     */
    @RequestMapping("/shoppingCart/removeFromCart")
    @ResponseBody
    public Map<String,String> removeFromCart(HttpServletRequest request, Long cartId){
        Map<String,String> ajaxMap;
        try {
            boolean bool = shoppingCartService.removeFromCart(cartId);
            if(bool){
                ajaxMap = AjaxUtil.generateResponseAjax("1", MsgConstants.OPERATE_SUCCESS);
            }else{
                ajaxMap = AjaxUtil.generateResponseAjax("0", MsgConstants.OPERATE_FAILURE);
            }
            return ajaxMap;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            return ajaxMap;
        }
    }

    /**
     * 查询购物车
     * @param userId 用户ID
     * @param pageNo 页码
     * @param pageSize 每页显示个数
     * @return PagedResult
     */
    @RequestMapping("/shoppingCart/queryShoppingCart")
    @ResponseBody
    public String queryShoppingCart(Long userId,Integer pageNo,Integer pageSize){
        PagedResult result;
        try {
            result = shoppingCartService.queryShoppingCartByPage(userId, pageNo, pageSize);
            return responseSuccess(result);
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return responseFail(MsgConstants.SYSTEM_ERROR);
        }
    }
}
