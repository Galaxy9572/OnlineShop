package org.ljy.controller;

import org.apache.log4j.Logger;
import org.ljy.domain.Payment;
import org.ljy.domain.ShoppingCart;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;
import org.ljy.enums.UserType;
import org.ljy.service.PaymentService;
import org.ljy.service.ShoppingCartService;
import org.ljy.service.UserService;
import org.ljy.util.AjaxUtil;
import org.ljy.util.EncryptUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
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
     * @return 买家中心页面
     */
    @RequestMapping("/user/buyerCenter")
    public String buyerCenterPage() {
        return "user/buyerCenter";
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
        return index();
    }

    /**
     * 检查用户是否可以被注册
     *
     * @param user 用户
     * @return ajax
     */
    @RequestMapping("/user/reg/checkIfCanReg")
    @ResponseBody
    public Map<String, String> checkIfCanReg(User user) {
        Map<String,String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        try {
            if (user != null && !StringUtil.isEmpty(user.getUserName())) {
                UserExample example = new UserExample();
                example.or().andUserNameEqualTo(user.getUserName());
                List<User> result = userService.selectByExample(example);
                if (result != null && result.size() > 0) {
                    ajaxMap.put("status", "0");
                    ajaxMap.put("msg", "该用户名已被注册");
                } else {
                    ajaxMap.put("status", "1");
                    ajaxMap.put("msg", "注册成功");
                }
            }
            return ajaxMap;
        } catch (Exception e) {
            LOG.info(e.getMessage(), e);
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", "系统异常");
            return ajaxMap;
        }
    }

    /**
     * 用户注册
     *
     * @param session HttpSession
     * @param user User
     * @return ajaxMap
     */
    @RequestMapping("/user/reg/userRegister")
    @Transactional
    @ResponseBody
    public Map<String, String> userRegister(HttpSession session, User user) {
        Map<String,String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        int userFlag = 0,cartFlag = 0,paymentFlag = 0;
        try {
            ShoppingCart shoppingCart = null;
            Payment payment = null;
            if (user != null && !StringUtil.isEmpty(user.getUserName())) {
                Date date = new Date();
                user.setPassword(EncryptUtil.encrypt(user.getPassword()));
                user.setUserType(UserType.BUYER.key());
                user.setRegTime(date);
                user.setModifyTime(date);
                userFlag = userService.insertSelective(user);
                if(userFlag > 0){
                    UserExample example = new UserExample();
                    example.or().andUserNameEqualTo(user.getUserName());
                    user = userService.selectByExample(example).get(0);
                    Long userId = user.getUserId();
                    shoppingCart = new ShoppingCart();
                    shoppingCart.setUserId(userId);
                    shoppingCart.setCreateTime(date);
                    shoppingCart.setModifyTime(date);
                    payment = new Payment();
                    payment.setUserId(userId);
                    payment.setCreateTime(date);
                    payment.setModifyTime(date);
                    cartFlag = shoppingCartService.insertSelective(shoppingCart);
                    paymentFlag = paymentService.insertSelective(payment);
                    if (cartFlag > 0 && paymentFlag > 0) {
                        LOG.info("用户ID：" + user.getUserId() + ",用户名：" + user.getUserName() + "注册成功");
                        session.setAttribute("user", user);
                        ajaxMap.put("status", "1");
                        ajaxMap.put("msg", "注册成功");
                    }
                }else{
                    ajaxMap.put("status", "0");
                    ajaxMap.put("msg", "注册失败");
                }
            }
            return ajaxMap;
        } catch (Exception e) {
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", "系统异常");
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
        Map<String,String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        try {
            String encryptedPassword = EncryptUtil.encrypt(user.getPassword());
            UserExample example = new UserExample();
            example.or().andUserNameEqualTo(user.getUserName()).andPasswordEqualTo(encryptedPassword);
            List<User> results = userService.selectByExampleWithBLOBs(example);
            User loginUser = null;
            if (results != null && results.size() > 0) {
                loginUser = results.get(0);
            }
            if (loginUser != null) {
                session.setAttribute("user", loginUser);
                ajaxMap.put("status", "1");
                ajaxMap.put("msg", "登录成功");
            } else {
                ajaxMap.put("status", "0");
                ajaxMap.put("msg", "用户名或者密码错误");
            }
            return ajaxMap;
        } catch (Exception e) {
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", "系统异常");
            LOG.warn(e.getMessage(), e);
            return ajaxMap;
        }
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
        Map<String,String> ajaxMap = AjaxUtil.createDefaultAjaxMap();
        int isSuccess = 0;
        try {
            if (user != null && !StringUtil.isEmpty(user.getUserName())) {
                UserExample example = new UserExample();
                example.or().andUserNameEqualTo(user.getUserName());
                isSuccess = userService.updateByExampleWithBLOBs(user, example);
            }
            if (isSuccess > 0) {
                ajaxMap.put("status", "1");
                ajaxMap.put("msg", "修改成功");
            } else {
                ajaxMap.put("status", "0");
                ajaxMap.put("msg", "修改失败");
            }
            return ajaxMap;
        } catch (Exception e) {
            ajaxMap.put("status", "0");
            ajaxMap.put("msg", "系统异常");
            LOG.warn(e.getMessage(), e);
            return ajaxMap;
        }
    }
}
