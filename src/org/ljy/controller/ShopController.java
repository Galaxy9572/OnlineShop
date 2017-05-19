package org.ljy.controller;

import org.ljy.common.MsgConstants;
import org.ljy.domain.Shop;
import org.ljy.domain.ShopExample;
import org.ljy.domain.User;
import org.ljy.enums.*;
import org.ljy.service.GoodsService;
import org.ljy.service.ShopService;
import org.ljy.service.UserService;
import org.ljy.util.AjaxUtil;
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

@Controller
public class ShopController extends BaseController{
    @Resource
    private UserService userService;

    @Resource
    private ShopService shopService;

    @Resource
    private GoodsService goodsService;

    /**
     * 返回卖家中心页面
     * @return 卖家中心页面
     */
    @RequestMapping("/shop/sellerCenter")
    public String sellerCenter(HttpSession session,HttpServletRequest request){
        User user = (User) session.getAttribute("user");
        if(user == null){
            return "user/userLogin";
        }else if(user.getUserType() != UserType.SELLER.key()){
            ShopExample example = new ShopExample();
            example.or().andUserIdEqualTo(user.getUserId());
            long num = shopService.countByExample(example);
            if(num > 0){
                Shop shop = shopService.getShop(example);
                request.setAttribute("shop",shop);
                return shopManagePage(request);
            }
            return openShopPage(request);
        }else{
            List<GoodsType> goods = new ArrayList<GoodsType>();
            Collections.addAll(goods,GoodsType.values());//将GoodsType的所有值加入List
            request.setAttribute("goodsType",goods);
            List<OrderStatement> orders = new ArrayList<OrderStatement>();
            Collections.addAll(orders,OrderStatement.values());
            request.setAttribute("orderStatement",orders);
            List<UserMessageStatement> msgs = new ArrayList<UserMessageStatement>();
            Collections.addAll(msgs,UserMessageStatement.values());
            request.setAttribute("userMsgStatement",msgs);
            return "shop/sellerCenter";
        }
    }

    /**
     * 开店页面
     * @param request HttpServletRequest
     * @return 开店页面
     */
    @RequestMapping("/shop/openShop")
    public String openShopPage(HttpServletRequest request){
        List<ShopType> shops = new ArrayList<ShopType>();
        Collections.addAll(shops,ShopType.values());
        request.setAttribute("shopType",shops);
        return "shop/openShop";
    }

    /**
     * 卖家中心页面
     * @param request HttpServletRequest
     * @return 卖家中心页面
     */
    @RequestMapping("/shop/shopManage")
    public String shopManagePage(HttpServletRequest request){
        List<GoodsType> goods = new ArrayList<GoodsType>();
        Collections.addAll(goods,GoodsType.values());//将GoodsType的所有值加入List
        long allUserGoodsNum = goodsService.countByExample(null);
        request.setAttribute("goodsType",goods);
        return "shop/sellerCenter";
    }

    /**
     * 开店
     * @param session HttpSession
     * @param user User
     * @param shop Shop
     * @return ajaxMap
     */
    @RequestMapping("/shop/openShop/confirm")
    @ResponseBody
    public Map<String,String> openShop(HttpSession session, User user,Shop shop){
        Map<String,String> ajaxMap;
        try {
            boolean bool = shopService.checkIfCanOpen(user, shop);
            if(!bool){
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SHOP_OPENED);
                return ajaxMap;
            }
            Shop result = shopService.openShop(user,shop);
            if(result != null){
                session.setAttribute("shop",result);
                ajaxMap = AjaxUtil.generateResponseAjax("1",MsgConstants.OPERATE_SUCCESS);
            }else{
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.OPERATE_FAILURE);
            }
            return ajaxMap;
        } catch (Exception e) {
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            LOG.info(e.getMessage(),e);
            return ajaxMap;
        }
    }

}
