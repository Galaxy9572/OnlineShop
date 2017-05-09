package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.ljy.common.PagedResult;
import org.ljy.dao.PaymentMapper;
import org.ljy.dao.ShoppingCartMapper;
import org.ljy.dao.UserMapper;
import org.ljy.domain.Payment;
import org.ljy.domain.ShoppingCart;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;
import org.ljy.enums.UserType;
import org.ljy.service.UserService;
import org.ljy.util.AjaxUtil;
import org.ljy.util.BeanUtil;
import org.ljy.util.EncryptUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Resource
    private ShoppingCartMapper shoppingCartMapper;

	@Resource
    private PaymentMapper paymentMapper;

	private static Logger LOG = Logger.getLogger(UserServiceImpl.class);

	@Override
	public User userRegister(User user) {
        int userFlag = 0,cartFlag = 0,paymentFlag = 0;
        User result = null;
        try {
            ShoppingCart shoppingCart = null;
            Payment payment = null;
            if (user != null && !StringUtil.isEmpty(user.getUserName())) {
                Date date = new Date();
                user.setPassword(EncryptUtil.encrypt(user.getPassword()));
                user.setUserType(UserType.BUYER.key());
                user.setRegTime(date);
                user.setModifyTime(date);
                userFlag = userMapper.insertSelective(user);
                if (userFlag > 0) {
                    UserExample example = new UserExample();
                    example.or().andUserNameEqualTo(user.getUserName());
                    user = userMapper.selectByExample(example).get(0);
                    Long userId = user.getUserId();
                    shoppingCart = new ShoppingCart();
                    shoppingCart.setUserId(userId);
                    shoppingCart.setCreateTime(date);
                    shoppingCart.setModifyTime(date);
                    payment = new Payment();
                    payment.setUserId(userId);
                    payment.setCreateTime(date);
                    payment.setModifyTime(date);
                    cartFlag = shoppingCartMapper.insertSelective(shoppingCart);
                    paymentFlag = paymentMapper.insertSelective(payment);
                    if (cartFlag > 0 && paymentFlag > 0) {
                        result = user;
                        LOG.info("用户ID：" + user.getUserId() + ",用户名：" + user.getUserName() + "注册成功");
                    }
                }
            }
            return result;
        }catch (Exception e){
            LOG.info("userService checkIfCanReg异常\n"+e.getMessage(), e);
            return null;
        }
	}

	@Override
	public User userLogin(User user) {
        User result = null;
        try {
            String encryptedPassword = EncryptUtil.encrypt(user.getPassword());
            UserExample example = new UserExample();
            example.or().andUserNameEqualTo(user.getUserName()).andPasswordEqualTo(encryptedPassword);
            List<User> results = userMapper.selectByExampleWithBLOBs(example);
            if (results.size() > 0) {
                result = results.get(0);
            }
            return result;
        } catch (Exception e) {
            LOG.warn("userService userLogin异常\n" +e.getMessage(), e);
            return null;
        }
	}

	@Override
	public boolean checkIfCanReg(User user) {
		boolean bool = false;
		try {
			if (user != null && !StringUtil.isEmpty(user.getUserName())) {
				UserExample example = new UserExample();
				example.or().andUserNameEqualTo(user.getUserName());
				List<User> result = userMapper.selectByExample(example);
				if (result.size() <= 0) {
					bool = true;
				}
			}
			return bool;
		} catch (Exception e) {
			LOG.info("userService checkIfCanReg异常\n"+e.getMessage(), e);
			return false;
		}
	}

    @Override
    public boolean checkIfCanLogin(User user) {
	    boolean bool = false;
        try {
            if (user != null && StringUtil.isNotNullAndNotEmpty(user.getUserName())) {
                UserExample example = new UserExample();
                example.or().andUserNameEqualTo(user.getUserName())
                .andPasswordEqualTo(EncryptUtil.encrypt(user.getPassword()));
                List<User> result = userMapper.selectByExample(example);
                if (result.size() > 0) {
                    bool = true;
                }
            }
            return bool;
        } catch (Exception e) {
            LOG.info("userService checkIfCanLogin异常\n"+e.getMessage(), e);
            return false;
        }
    }

    @Override
	public boolean modifyInfo(User user) {
        int isSuccess = 0;
        boolean bool = false;
        try {
            if (user != null && !StringUtil.isEmpty(user.getUserName())) {
                UserExample example = new UserExample();
                example.or().andUserNameEqualTo(user.getUserName());
                isSuccess = userMapper.updateByExampleWithBLOBs(user, example);
            }
            if (isSuccess > 0) {
                bool = true;
            }
            return bool;
        } catch (Exception e) {
            LOG.info("userService modifyInfo异常\n"+e.getMessage(), e);
            return false;
        }
	}

	@Override
	public PagedResult selectByExampleWithBLOBsByPage(UserExample example, Integer pageNo, Integer pageSize ) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		return BeanUtil.toPagedResult(userMapper.selectByExampleWithBLOBs(example));
	}

	@Override
	public PagedResult selectByExampleByPage(UserExample example, Integer pageNo, Integer pageSize ) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);
		return BeanUtil.toPagedResult(userMapper.selectByExample(example));
	}

    @Override
    public long countByExample(UserExample example) {
        return userMapper.countByExample(example);
    }

}
