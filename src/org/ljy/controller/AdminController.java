package org.ljy.controller;

import org.apache.log4j.Logger;
import org.ljy.common.MsgConstants;
import org.ljy.common.PagedResult;
import org.ljy.domain.GoodsExample;
import org.ljy.domain.ShopExample;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;
import org.ljy.enums.ShopType;
import org.ljy.enums.UserType;
import org.ljy.service.AdminService;
import org.ljy.service.GoodsService;
import org.ljy.service.ShopService;
import org.ljy.service.UserService;
import org.ljy.util.AjaxUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by ljy56 on 2017/4/11.
 */
@Controller
public class AdminController extends BaseController {
    private static Logger LOG = Logger.getLogger(AdminController.class);
    @Resource
    private AdminService adminService;

    @Resource
    private UserService userService;

    @Resource
    private ShopService shopService;

    @Resource
    private GoodsService goodsService;

    /**
     * 返回管理员首页
     *
     * @param session HttpSession
     * @return 未登录返回登录页面，登陆了返回管理员首页
     */
    @RequestMapping("/admin/index")
    public String adminPage(HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "admin/adminLogin";
        } else {
            List<ShopType> shopTypes = new ArrayList<ShopType>();
            Collections.addAll(shopTypes, ShopType.values());
            Long allUserNum = userService.countByExample(null);
            Long allShopNum = shopService.countByExample(null);
            Long allGoodsNum = goodsService.countByExample(null);
            request.setAttribute("shopTypes", shopTypes);
            request.setAttribute("allUserNum",allUserNum);
            request.setAttribute("allShopNum",allShopNum);
            request.setAttribute("allGoodsNum",allGoodsNum);
            return "admin/adminIndex";
        }
    }

    /**
     * 管理员登录
     *
     * @param session HttpSession
     * @param user    User
     * @return ajaxMap
     */
    @RequestMapping("/admin/login")
    @ResponseBody
    public Map<String, String> adminLogin(HttpSession session, User user) {
        Map<String, String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        try {
            User result = userService.userLogin(user);
            if(result != null){
                if(result.getUserType() == UserType.ADMIN.key()){
                    ajaxMap.put("status", "1");
                    ajaxMap.put("msg", MsgConstants.LOGIN_SUCCESS);
                }else{
                    ajaxMap.put("status", "0");
                    ajaxMap.put("msg", MsgConstants.NO_PRIVILEGE);
                }
            }else{
                ajaxMap.put("status", "0");
                ajaxMap.put("msg", MsgConstants.LOGIN_FAILURE);
            }
        } catch (Exception e) {
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", MsgConstants.SYSTEM_ERROR);
            LOG.warn(e.getMessage(), e);
            return ajaxMap;
        }
        return ajaxMap;
    }

    @RequestMapping("/admin/deleteUser")
    @ResponseBody
    public Map<String, String> deleteUser(String userId){
        Map<String, String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        try {
            if(StringUtil.isNotNullAndNotEmpty(userId)){
                UserExample example = new UserExample();
                example.or().andUserIdEqualTo(Long.parseLong(userId));
                boolean flag = adminService.deleteUser(example);
                if(flag){
                    ajaxMap.put("status","1");
                    ajaxMap.put("msg",MsgConstants.OPERATE_SUCCESS);
                }else{
                    ajaxMap.put("status","0");
                    ajaxMap.put("msg",MsgConstants.OPERATE_FAILURE);
                }
            }else{
                ajaxMap.put("status","0");
                ajaxMap.put("msg",MsgConstants.WRONG_PARAMETERS);
            }
        } catch (NumberFormatException e) {
            ajaxMap.put("status","0");
            ajaxMap.put("msg",MsgConstants.SYSTEM_ERROR);
        }
        return ajaxMap;
    }

    /**
     * 根据用户名查询用户
     *
     * @param userName 用户名
     */
    @RequestMapping("/admin/queryUserByCondition")
    @ResponseBody
    public String queryUserByCondition(HttpServletRequest request, String userName, String userType, int pageNumber, int pageSize) {
        UserExample example = new UserExample();
        PagedResult result = null;
        int userTypeInt = 0;
        try {
            if (StringUtil.isNotNullAndNotEmpty(userType)) {
                userTypeInt = Integer.parseInt(userType);
                if (StringUtil.isNotNullAndNotEmpty(userName)) {
                    example.or().andUserNameEqualTo(userName);
                }
                switch (userTypeInt) {
                    case 0:
                        result = userService.selectByExampleByPage(example, pageNumber, pageSize);
                        break;
                    default:
                        example.or().andUserTypeEqualTo(userTypeInt);
                        result = userService.selectByExampleByPage(example, pageNumber, pageSize);
                        break;
                }
                return responseSuccess(result);
            } else {
                return responseFail(MsgConstants.WRONG_PARAMETERS);
            }
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return responseFail(MsgConstants.SYSTEM_ERROR + e.getMessage());
        }
    }

    /**
     * 按商店名查找商店
     *
     * @param request  HttpServletRequest
     * @param shopName 商店名
     */
    @RequestMapping("/admin/queryShopByCondition")
    @ResponseBody
    public String queryShopByCondition(HttpServletRequest request, String shopName, String shopType, int pageNumber, int pageSize) {
        ShopExample example = new ShopExample();
        PagedResult result = null;
        int shopTypeInt = 0;
        try {
            if (StringUtil.isNotNullAndNotEmpty(shopType)) {
                shopTypeInt = Integer.parseInt(shopType);
                if (StringUtil.isNotNullAndNotEmpty(shopName)) {
                    example.or().andShopNameLike("%"+shopName+"%");
                }
                switch (shopTypeInt) {
                    case 0:
                        result = shopService.selectByExampleByPage(example, pageNumber, pageSize);
                        break;
                    default:
                        example.or().andShopTypeEqualTo(shopTypeInt);
                        result = shopService.selectByExampleByPage(example, pageNumber, pageSize);
                        break;
                }
                return responseSuccess(result);
            }else{
                return responseFail(MsgConstants.WRONG_PARAMETERS);
            }
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return responseFail(MsgConstants.SYSTEM_ERROR);
        }
    }

    /**
     * 按商品名查询商品
     *
     * @param request   HttpServletRequest
     * @param goodsName 商品名
     */
    @RequestMapping("/admin/queryGoodsByCondition")
    @ResponseBody
    public String queryGoodsByCondition(HttpServletRequest request, String goodsName, String goodsType, int pageNumber, int pageSize) {
        GoodsExample example = new GoodsExample();
        PagedResult result = null;
        try {
            if (StringUtil.isNotNullAndNotEmpty(goodsType)) {
                int goodsTypeInt = 0;
                if(StringUtil.isNotNullAndNotEmpty(goodsName)){
                    example.or().andGoodsNameLike("%" + goodsName + "%");
                }
                switch (goodsTypeInt){
                    case 0 :
                        result = goodsService.selectByExampleByPage(example,pageNumber,pageSize);
                        break;
                    default :
                        example.or().andGoodsTypeEqualTo(goodsTypeInt);
                        result = goodsService.selectByExampleByPage(example,pageNumber,pageSize);
                        break;
                }
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
