package org.ljy.controller;

import org.apache.log4j.Logger;
import org.ljy.common.Page;
import org.ljy.domain.*;
import org.ljy.enums.UserType;
import org.ljy.service.GoodsService;
import org.ljy.service.ShopService;
import org.ljy.service.UserService;
import org.ljy.util.EncryptUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ljy56 on 2017/4/11.
 */
@Controller
public class AdminController {
    private static Logger LOG = Logger.getLogger(AdminController.class);
    @Resource
    private UserService userService;

    @Resource
    private ShopService shopService;

    @Resource
    private GoodsService goodsService;
    /**
     * 返回管理员首页
     * @param session HttpSession
     * @return 未登录返回登录页面，登陆了返回管理员首页
     */
    @RequestMapping("/admin/index")
    public String adminPage(HttpSession session,HttpServletRequest request){
       User user = (User) session.getAttribute("user");
        if(user == null){
            return "admin/adminLogin";
        }else{
            return "admin/adminIndex";
        }
    }

    /**
     * 管理员登录
     * @param session HttpSession
     * @param user User
     * @return ajaxMap
     */
    @RequestMapping("/admin/login")
    @ResponseBody
    public Map<String,String> adminLogin(HttpSession session, User user){
        Map<String,String> ajaxMap = new HashMap<String,String>();
        try {
            String userName = user.getUserName();
            String password = EncryptUtil.encrypt(user.getPassword());
            if(!StringUtil.isEmpty(userName) && !StringUtil.isEmpty(password)){
                UserExample example = new UserExample();
                example.or().andUserNameEqualTo(userName).andPasswordEqualTo(password).andUserTypeEqualTo(UserType.ADMIN.key());
                List<User> users = userService.selectByExampleWithBLOBs(example);
                if(users != null && users.size() > 0){
                    user = users.get(0);
                    if(user.getUserType() == UserType.ADMIN.key()){
                        session.setAttribute("user",user);
                        ajaxMap.put("status","1");
                        ajaxMap.put("msg","登录成功");
                    }else{
                        ajaxMap.put("status","0");
                        ajaxMap.put("msg","你没有管理员权限");
                    }
                }else{
                    ajaxMap.put("status","0");
                    ajaxMap.put("msg","用户名或者密码错误");
                }
            }else{
                ajaxMap.put("status","0");
                ajaxMap.put("msg","参数提交错误");
            }
        } catch (Exception e) {
            ajaxMap.put("status","0");
            ajaxMap.put("msg","系统错误");
            LOG.warn(e.getMessage(),e);
            return ajaxMap;
        }
        return ajaxMap;
    }

    /**
     * 根据用户名查询用户
     * @param userId 查询种类，userId，userName
     * @param userName 查询参数
     */
    @RequestMapping("/admin/queryBuyerByCondition")
    public void queryBuyerByCondition(HttpServletRequest request,String userId,String userName){
        try {
            if(StringUtil.isEmpty(userId) && !StringUtil.isEmpty(userName)){
                UserExample example = new UserExample();
                example.or().andUserNameLike("%"+userName+"%");
                List<User> users = userService.selectByExample(example);
                //TODO
            }
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
        }
    }

    /**
     * 查询所有买家
     * @param request HttpServletRequest
     * @param page Page
     */
    private void queryAllBuyers(HttpServletRequest request,Page page){
        try {
            UserExample buyerExample = new UserExample();
            buyerExample.or().andUserTypeEqualTo(UserType.BUYER.key());
            List<User> allBuyers = userService.selectByExampleByPage(buyerExample,page);
            request.setAttribute("allBuyers",allBuyers);
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
        }
    }

    /**
     * 查询所有买家
     * @param request HttpServletRequest
     * @param page Page
     */
    public String queryAllSellers(HttpServletRequest request,Page page){
        try {
            UserExample sellerExample = new UserExample();
            sellerExample.or().andUserTypeEqualTo(UserType.SELLER.key());
            List<User> allSellers = userService.selectByExampleByPage(sellerExample,page);
            request.setAttribute("allSellers",allSellers);
            return "admin/adminIndex";
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return "admin/adminIndex";
        }
    }

    /**
     * 按商店名查找商店
     * @param request HttpServletRequest
     * @param shopName 商店名
     */
    public void queryAllShops(HttpServletRequest request,String shopName){
        try {
            if(!StringUtil.isEmpty(shopName)){
                ShopExample example = new ShopExample();
                example.or().andShopNameLike("%"+shopName+"%");
                List<Shop> shops = shopService.selectByExample(example);
                //TODO
            }

        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
        }
    }

    /**
     * 按商品名查询商品
     * @param request HttpServletRequest
     * @param goodsName 商品名
     */
    public void queryAllGoods(HttpServletRequest request,String goodsName){
        try {
            if(!StringUtil.isEmpty(goodsName)){
                GoodsExample example = new GoodsExample();
                example.or().andGoodsNameLike("%"+goodsName+"%");
                List<Goods> goods = goodsService.selectByExample(example);
                //TODO
            }

        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
        }
    }
}