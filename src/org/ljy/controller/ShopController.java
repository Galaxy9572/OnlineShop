package org.ljy.controller;

import org.apache.log4j.Logger;
import org.ljy.domain.Shop;
import org.ljy.domain.ShopExample;
import org.ljy.domain.User;
import org.ljy.enums.GoodsType;
import org.ljy.enums.ShopType;
import org.ljy.enums.UserType;
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
import java.util.*;

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
        }else if(user.getUserType() != UserType.SELLER.key() && user.getUserType() != UserType.ADMIN.key()){
            return "shop/openShop";
        }else{
            List<GoodsType> goods = new ArrayList<GoodsType>();
            Collections.addAll(goods,GoodsType.values());//将GoodsType的所有值加入List
            request.setAttribute("goodsType",goods);
            return "shop/sellerCenter";
        }
    }

    @RequestMapping("/shop/openShop")
    public String openShopPage(HttpServletRequest request){
        List<String> shops = new ArrayList<String>();
        for(ShopType shopType: ShopType.values()){
            shops.add(shopType.value());
        }
        request.setAttribute("shopType",shops);
        return "shop/openShop";
    }

    @RequestMapping("/shop/openShop/confirm")
    @ResponseBody
    public Map<String,String> openShop(HttpSession session, User user,Shop shop){
        Map<String,String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        try {
            if(user.getUserId() !=null && !StringUtil.isEmpty(shop.getShopName())){
                Long userId = user.getUserId();
                Date date = new Date();
                ShopExample example =new ShopExample();
                example.or().andUserIdEqualTo(userId);
                List<Shop> userShop = shopService.selectByExample(example);
                if(userShop.size()>0){
                    ajaxMap.put("status", "0");
                    ajaxMap.put("msg", "你已经开过一个商店了");
                    return ajaxMap;
                }
                shop.setUserId(userId);
                shop.setCreateTime(date);
                shop.setModifyTime(date);
                int flag = shopService.insertSelective(shop);
                user.setUserType(UserType.SELLER.key());
                int isSuccess = userService.updateByPrimaryKeySelective(user);
                if(flag > 0 && isSuccess > 0){
                    ajaxMap.put("status", "1");
                    ajaxMap.put("msg", "开店成功");
                }else{
                    ajaxMap.put("status", "0");
                    ajaxMap.put("msg", "开店失败");
                }
            }
        } catch (Exception e) {
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", "系统异常");
            LOG.info(e.getMessage(),e);
        }
        return ajaxMap;
    }

}
