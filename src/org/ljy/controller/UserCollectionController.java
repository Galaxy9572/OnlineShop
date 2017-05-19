package org.ljy.controller;

import org.ljy.common.MsgConstants;
import org.ljy.domain.UserCollection;
import org.ljy.service.UserCollectionService;
import org.ljy.util.AjaxUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * ljy56
 * 2017/5/13
 */
@Controller
public class UserCollectionController extends BaseController {
    @Resource
    private UserCollectionService userCollectionService;

    @RequestMapping("/collect/collect")
    @ResponseBody
    public Map<String,String> collect(UserCollection userCollection){
        Map<String,String> ajaxMap;
        try {
            boolean bool = userCollectionService.collect(userCollection);
            if(bool){
                ajaxMap = AjaxUtil.generateResponseAjax("1", MsgConstants.OPERATE_SUCCESS);
            }else{
                ajaxMap = AjaxUtil.generateResponseAjax("0", MsgConstants.OPERATE_FAILURE);
            }
            return ajaxMap;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            ajaxMap = AjaxUtil.generateResponseAjax("0", MsgConstants.SYSTEM_ERROR);
            return ajaxMap;
        }
    }

    @RequestMapping("/collect/removeCollection")
    @ResponseBody
    public Map<String,String> collect(Long collectionId){
        Map<String,String> ajaxMap;
        try {
            boolean bool = userCollectionService.removeCollection(collectionId);
            if(bool){
                ajaxMap = AjaxUtil.generateResponseAjax("1", MsgConstants.OPERATE_SUCCESS);
            }else{
                ajaxMap = AjaxUtil.generateResponseAjax("0", MsgConstants.OPERATE_FAILURE);
            }
            return ajaxMap;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            ajaxMap = AjaxUtil.generateResponseAjax("0", MsgConstants.SYSTEM_ERROR);
            return ajaxMap;
        }
    }
}

