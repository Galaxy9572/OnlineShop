package org.ljy.controller;

import org.ljy.common.MsgConstants;
import org.ljy.common.PagedResult;
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
 * ljy56
 * 2017/5/13
 */
@Controller
public class UserMessageController extends BaseController{
    @Resource
    private UserMessageService userMessageService;

    @RequestMapping("/userMsg/deleteMsg")
    @ResponseBody
    public Map<String,String> deleteMessageByMessageId(Long messageId){
        Map<String,String> ajaxMap = null;
        try {
                boolean flag = userMessageService.deleteMessageByMessage(messageId);
                if(flag){
                    ajaxMap = AjaxUtil.generateResponseAjax("1",MsgConstants.OPERATE_SUCCESS);
                }else {
                    ajaxMap = AjaxUtil.generateResponseAjax("0", MsgConstants.OPERATE_FAILURE);
                }
            return ajaxMap;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            return ajaxMap;
        }
    }

    @RequestMapping("/userMsg/queryMsgByCondition")
    @ResponseBody
    public String queryMsgByCondition(HttpServletRequest request, String userId,String statement, Integer pageNo, Integer pageSize){
        PagedResult result;
        try {
            if(StringUtil.isNotNullAndNotEmpty(userId) && StringUtil.isNotNullAndNotEmpty(statement)){
                result = userMessageService.queryMsgByCondition(userId,statement,pageNo,pageSize);
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
