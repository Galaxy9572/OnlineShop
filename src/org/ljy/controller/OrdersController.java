package org.ljy.controller;

import org.ljy.common.MsgConstants;
import org.ljy.common.PagedResult;
import org.ljy.domain.Orders;
import org.ljy.domain.UserMessage;
import org.ljy.service.OrdersService;
import org.ljy.service.UserMessageService;
import org.ljy.util.AjaxUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author ljy56
 * 2017/4/13.
 */
@Controller
public class OrdersController extends BaseController{
    @Resource
    private OrdersService ordersService;

    @Resource
    private UserMessageService userMessageService;

    @RequestMapping("/order/addOrder")
    @ResponseBody
    public Map<String,String> addOrder(HttpServletRequest request,Orders orders){
        Map<String, String> ajaxMap;
        try {
            boolean bool = ordersService.addOrder(orders);
            UserMessage message = new UserMessage();
            message.setFromUserId(orders.getUserId());
            message.setUserId(orders.getSellerId());
            message.setContext("你有新的订单，请及时处理");
            bool = userMessageService.sendMessage(message);
            if(bool){
                ajaxMap = AjaxUtil.generateResponseAjax("1",MsgConstants.OPERATE_SUCCESS);
            }else{
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.OPERATE_FAILURE);
            }
            return ajaxMap;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            return ajaxMap;
        }
    }

    @RequestMapping("/order/deleteOrder")
    @ResponseBody
    public Map<String,String> deleteOrder(HttpServletRequest request,Long orderId){
        Map<String, String> ajaxMap;
        try {
            boolean bool = ordersService.deleteOrderByOrderId(orderId);
            if(bool){
                ajaxMap = AjaxUtil.generateResponseAjax("1",MsgConstants.OPERATE_SUCCESS);
            }else{
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.OPERATE_FAILURE);
            }
            return ajaxMap;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            return ajaxMap;
        }
    }

    @RequestMapping("/order/updateOrder")
    @ResponseBody
    public Map<String,String> updateOrder(HttpServletRequest request,Orders orders){
        Map<String, String> ajaxMap;
        try {
            boolean bool = ordersService.updateOrder(orders);
            if(bool){
                ajaxMap = AjaxUtil.generateResponseAjax("1",MsgConstants.OPERATE_SUCCESS);
            }else{
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.OPERATE_FAILURE);
            }
            return ajaxMap;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            return ajaxMap;
        }
    }

    @RequestMapping("/order/queryOrderByCondition")
    @ResponseBody
    public String queryOrderByCondition(HttpServletRequest request,String queryType,String userType, String userId, String statement, Integer pageNumber, Integer pageSize){
        PagedResult result;
        try {
            if(StringUtil.isNotNullAndNotEmpty(queryType)&&StringUtil.isNotNullAndNotEmpty(userId)&&StringUtil.isNotNullAndNotEmpty(statement)){
                result = ordersService.queryOrdersByPage(queryType,userId,statement,pageNumber,pageSize);
                return responseSuccess(result);
            }else{
                return responseFail(MsgConstants.WRONG_PARAMETERS);
            }
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return responseFail(MsgConstants.SYSTEM_ERROR);
        }
    }
}
