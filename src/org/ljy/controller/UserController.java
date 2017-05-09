package org.ljy.controller;

import org.apache.log4j.Logger;
import org.ljy.common.MsgConstants;
import org.ljy.domain.User;
import org.ljy.service.PaymentService;
import org.ljy.service.ShoppingCartService;
import org.ljy.service.UserService;
import org.ljy.util.AjaxUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author 廖俊瑶
 */
@Controller
public class UserController {
    private static Logger LOG = Logger.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private PaymentService paymentService;

    @Resource
    private ShoppingCartService shoppingCartService;

    /**
     * 返回首页
     *
     * @return 首页
     */
    @RequestMapping("/")
    public String index() {
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
    public String buyerCenterPage() {
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
        Map<String, String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        try {
            boolean bool = userService.checkIfCanReg(user);
            if (!bool) {
                ajaxMap.put("status", "0");
                ajaxMap.put("msg", MsgConstants.USER_REGED);
                return ajaxMap;
            }
            User regUser = userService.userRegister(user);
            if (regUser != null) {
                session.setAttribute("user", regUser);
                ajaxMap.put("status", "1");
                ajaxMap.put("msg", MsgConstants.REG_SUCCESS);
            } else {
                ajaxMap.put("status", "0");
                ajaxMap.put("msg", MsgConstants.SYSTEM_ERROR);
            }
            return ajaxMap;
        } catch (Exception e) {
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", "注册失败，用户控制器异常");
            LOG.warn("userController userRegister异常\n" + e.getMessage(), e);
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
        Map<String, String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        try {
            boolean canLogin = userService.checkIfCanLogin(user);
            if (!canLogin) {
                ajaxMap.put("status", "0");
                ajaxMap.put("msg", MsgConstants.WRONG_USER_NAME_PSW);
                return ajaxMap;
            }
            User loginUser = userService.userLogin(user);
            if (loginUser != null) {
                session.setAttribute("user", loginUser);
                ajaxMap.put("status", "1");
                ajaxMap.put("msg", MsgConstants.LOGIN_SUCCESS);
            } else {
                ajaxMap.put("status", "0");
                ajaxMap.put("msg", MsgConstants.SYSTEM_ERROR);
            }
            return ajaxMap;
        } catch (Exception e) {
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", "登录失败，用户控制器异常");
            LOG.warn("userController userLogin异常\n" + e.getMessage(), e);
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
        Map<String, String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        try {
            boolean bool = userService.modifyInfo(user);
            if (!bool) {
                ajaxMap.put("status", "0");
                ajaxMap.put("msg", MsgConstants.OPERATE_FAILURE);
            } else {
                ajaxMap.put("status", "1");
                ajaxMap.put("msg", MsgConstants.OPERATE_SUCCESS);
            }
            return ajaxMap;
        } catch (Exception e) {
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", "修改失败，用户控制器异常");
            LOG.warn("userController modifyInfo异常\n" + e.getMessage(), e);
            return ajaxMap;
        }
    }
}
