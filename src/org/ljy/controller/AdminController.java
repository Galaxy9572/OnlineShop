package org.ljy.controller;

import org.apache.log4j.Logger;
import org.ljy.common.PagedResult;
import org.ljy.domain.GoodsExample;
import org.ljy.domain.ShopExample;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;
import org.ljy.enums.ShopType;
import org.ljy.enums.UserType;
import org.ljy.service.GoodsService;
import org.ljy.service.ShopService;
import org.ljy.service.UserService;
import org.ljy.util.AjaxUtil;
import org.ljy.util.EncryptUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by ljy56 on 2017/4/11.
 */
@Controller
public class AdminController extends BaseController {
    private static Logger LOG = Logger.getLogger(AdminController.class);
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
            String userName = user.getUserName();
            String password = EncryptUtil.encrypt(user.getPassword());
            if (StringUtil.isNotNullAndNotEmpty(userName) && StringUtil.isNotNullAndNotEmpty(password)) {
                UserExample example = new UserExample();
                example.or().andUserNameEqualTo(userName).andPasswordEqualTo(password).andUserTypeEqualTo(UserType.ADMIN.key());
                List<User> users = userService.selectByExampleWithBLOBs(example);
                if (users != null && users.size() > 0) {
                    user = users.get(0);
                    if (user.getUserType() == UserType.ADMIN.key()) {
                        session.setAttribute("user", user);
                        ajaxMap.put("status", "1");
                        ajaxMap.put("msg", "登录成功");
                    } else {
                        ajaxMap.put("status", "0");
                        ajaxMap.put("msg", "你没有管理员权限");
                    }
                } else {
                    ajaxMap.put("status", "0");
                    ajaxMap.put("msg", "用户名或者密码错误");
                }
            } else {
                ajaxMap.put("status", "0");
                ajaxMap.put("msg", "参数提交错误");
            }
        } catch (Exception e) {
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", "系统错误");
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
                int flag = userService.deleteByExample(example);
                if(flag > 0){
                    ajaxMap.put("status","1");
                    ajaxMap.put("msg","删除成功");
                }else{
                    ajaxMap.put("status","0");
                    ajaxMap.put("msg","删除失败");
                }
            }else{
                ajaxMap.put("status","0");
                ajaxMap.put("msg","参数错误");
            }
        } catch (NumberFormatException e) {
            ajaxMap.put("status","0");
            ajaxMap.put("msg","系统错误");
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
                return responseFail("参数错误");
            }
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return responseFail("系统错误：" + e.getMessage());
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
    public String queryAllShops(HttpServletRequest request, String shopName, String shopType, int pageNumber, int pageSize) {
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
                return responseFail("参数错误");
            }
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return responseFail("系统错误");
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
                return responseFail("参数错误");
            }
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return responseFail("系统错误");
        }
    }
}
