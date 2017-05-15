package org.ljy.controller;

import org.ljy.common.MsgConstants;
import org.ljy.domain.Shop;
import org.ljy.domain.ShopExample;
import org.ljy.domain.User;
import org.ljy.enums.GoodsType;
import org.ljy.enums.OrderStatement;
import org.ljy.enums.UserMessageStatement;
import org.ljy.enums.UserType;
import org.ljy.service.BankCardService;
import org.ljy.service.ShopService;
import org.ljy.service.ShoppingCartService;
import org.ljy.service.UserService;
import org.ljy.util.AjaxUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
 * @author 廖俊瑶
 */
@Controller
public class UserController extends BaseController{
    @Resource
    private UserService userService;

    @Resource
    private ShopService shopService;

    @Resource
    private BankCardService paymentService;

    @Resource
    private ShoppingCartService shoppingCartService;

    /**
     * 返回首页
     *
     * @return 首页
     */
    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        return "../../index";
    }

    /**
     * 返回注册页面
     *
     * @return 注册页面
     */
    @RequestMapping("/user/reg")
    public String userRegPage() {
        return "user/userReg";
    }

    /**
     * 返回登录页面
     *
     * @return 登录页面
     */
    @RequestMapping("/user/login")
    public String userLoginPage() {
        return "user/userLogin";
    }

    /**
     * 返回用户信息页面
     *
     * @return 用户信息页面
     */
    @RequestMapping("/user/info")
    public String userInfoPage() {
        return "user/userInfo";
    }

    /**
     * 返回买家中心页面
     *
     * @return 买家中心页面
     */
    @RequestMapping("/user/buyerCenter")
    public String buyerCenterPage(HttpServletRequest request) {
        List<GoodsType> goods = new ArrayList<GoodsType>();
        Collections.addAll(goods,GoodsType.values());//将GoodsType的所有值加入List
        request.setAttribute("goodsType",goods);
        List<OrderStatement> orders = new ArrayList<OrderStatement>();
        Collections.addAll(orders,OrderStatement.values());
        request.setAttribute("orderStatement",orders);
        List<UserMessageStatement> msgs = new ArrayList<UserMessageStatement>();
        Collections.addAll(msgs,UserMessageStatement.values());
        request.setAttribute("userMsgStatement",msgs);
        return "user/buyerCenter";
    }

    /**
     * 用户注册
     *
     * @param session HttpSession
     * @param user    User
     * @return ajaxMap
     */
    @RequestMapping("/user/reg/userRegister")
    @Transactional
    @ResponseBody
    public Map<String, String> userRegister(HttpSession session, User user) {
        Map<String, String> ajaxMap = null;
        try {
            boolean bool = userService.checkIfCanReg(user);
            if (!bool) {
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.USER_REGED);
                return ajaxMap;
            }
            User regUser = userService.userRegister(user);
            if (regUser != null) {
                session.setAttribute("user", regUser);
                ajaxMap = AjaxUtil.generateResponseAjax("1",MsgConstants.REG_SUCCESS);
            } else {
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            }
            return ajaxMap;
        } catch (Exception e) {
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            LOG.warn(e.getMessage(), e);
            return ajaxMap;
        }
    }

    /**
     * 用户登录
     *
     * @param session HttpSession
     * @param user    User
     * @return 首页
     */
    @RequestMapping("/user/login/userLogin")
    @ResponseBody
    public Map<String, String> userLogin(HttpSession session, User user) {
        Map<String, String> ajaxMap = null;
        try {
            boolean canLogin = userService.checkIfCanLogin(user);
            if (!canLogin) {
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.WRONG_USER_NAME_PSW);
                return ajaxMap;
            }
            User loginUser = userService.userLogin(user);
            if (loginUser != null) {
                session.setAttribute("user", loginUser);
                if(loginUser.getUserType() == UserType.SELLER.key()){
                    ShopExample example = new ShopExample();
                    example.or().andUserIdEqualTo(loginUser.getUserId());
                    Shop shop = shopService.getShop(example);
                    session.setAttribute("userShop", shop);
                }
                ajaxMap = AjaxUtil.generateResponseAjax("1",MsgConstants.LOGIN_SUCCESS);
            } else {
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            }
            return ajaxMap;
        } catch (Exception e) {
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            LOG.warn(e.getMessage(), e);
            return ajaxMap;
        }
    }

    /**
     * 用户退出登录
     *
     * @param session HttpSession
     * @param user    User
     * @return 返回主页
     */
    @RequestMapping("/user/logout")
    public String userLogout(HttpSession session, User user) {
        session.removeAttribute("user");
        return "redirect:../";
    }

    /**
     * 修改用户的信息
     *
     * @param session HttpSession
     * @param user    User
     * @return ajax
     */
    @RequestMapping("/user/modifyInfo")
    @ResponseBody
    public Map<String, String> modifyInfo(HttpSession session, User user) {
        Map<String, String> ajaxMap = null;
        try {
            boolean bool = userService.modifyInfo(user);
            if (!bool) {
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.OPERATE_FAILURE);
            } else {
                ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.OPERATE_SUCCESS);
            }
            return ajaxMap;
        } catch (Exception e) {
            ajaxMap = AjaxUtil.generateResponseAjax("0",MsgConstants.SYSTEM_ERROR);
            LOG.warn(e.getMessage(), e);
            return ajaxMap;
        }
    }
}
