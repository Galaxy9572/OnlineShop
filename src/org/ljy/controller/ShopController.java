package org.ljy.controller;

import org.apache.log4j.Logger;
import org.ljy.common.MsgConstants;
import org.ljy.domain.Shop;
import org.ljy.domain.ShopExample;
import org.ljy.domain.User;
import org.ljy.enums.GoodsType;
import org.ljy.enums.ShopType;
import org.ljy.enums.UserType;
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
public class ShopController {
    private static Logger LOG = Logger.getLogger(ShopController.class);
    @Resource
    private UserService userService;

    @Resource
    private ShopService shopService;

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
            return "shop/sellerCenter";
        }
    }

    @RequestMapping("/shop/openShop")
    public String openShopPage(HttpServletRequest request){
        List<ShopType> shops = new ArrayList<ShopType>();
        Collections.addAll(shops,ShopType.values());
        request.setAttribute("shopType",shops);
        return "shop/openShop";
    }

    @RequestMapping("/shop/shopManage")
    public String shopManagePage(HttpServletRequest request){
        return "shop/shopManage";
    }

    @RequestMapping("/shop/openShop/confirm")
    @ResponseBody
    public Map<String,String> openShop(HttpSession session, User user,Shop shop){
        Map<String,String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        try {
            boolean bool = shopService.checkIfCanOpen(user, shop);
            if(!bool){
                ajaxMap.put("status","0");
                ajaxMap.put("msg", MsgConstants.SHOP_OPENED);
                return ajaxMap;
            }
            Shop result = shopService.openShop(user,shop);
            if(result != null){
                session.setAttribute("shop",result);
                ajaxMap.put("status","1");
                ajaxMap.put("msg", MsgConstants.OPERATE_SUCCESS);
            }else{
                ajaxMap.put("status","0");
                ajaxMap.put("msg", MsgConstants.OPERATE_FAILURE);
            }
        } catch (Exception e) {
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", MsgConstants.SYSTEM_ERROR);
            LOG.info(e.getMessage(),e);
        }
        return ajaxMap;
    }

}
