package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.ljy.common.PagedResult;
import org.ljy.dao.UserMapper;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;
import org.ljy.enums.UserType;
import org.ljy.service.UserService;
import org.ljy.util.BeanUtil;
import org.ljy.util.EncryptUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private static Logger LOG = Logger.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User userRegister(User user) {
        User result = null;
        try {
            if (user != null && StringUtil.isNotNullAndNotEmpty(user.getUserName())) {
                Date date = new Date();
                user.setPassword(EncryptUtil.encrypt(user.getPassword()));
                user.setUserType(UserType.BUYER.key());
                user.setRegTime(date);
                user.setModifyTime(date);
                int flag = userMapper.insertSelective(user);
                if (flag > 0) {
                    UserExample example = new UserExample();
                    example.or().andUserNameEqualTo(user.getUserName());
                    result = userMapper.selectByExample(example).get(0);
                }
            }
            return result;
        } catch (Exception e) {
            LOG.info("userService checkIfCanReg异常\n" + e.getMessage(), e);
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
            LOG.warn("userService userLogin异常\n" + e.getMessage(), e);
            return null;
        }
    }

    @Override
    public boolean checkIfCanReg(User user) {
        List<User> result = new ArrayList<User>();
        try {
            if (user != null && !StringUtil.isEmpty(user.getUserName())) {
                UserExample example = new UserExample();
                example.or().andUserNameEqualTo(user.getUserName());
                result = userMapper.selectByExample(example);
            }
            return result.size() <= 0;
        } catch (Exception e) {
            LOG.info("userService checkIfCanReg异常\n" + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean checkIfCanLogin(User user) {
        List<User> result = new ArrayList<User>();
        try {
            if (user != null && StringUtil.isNotNullAndNotEmpty(user.getUserName())) {
                UserExample example = new UserExample();
                example.or().andUserNameEqualTo(user.getUserName())
                        .andPasswordEqualTo(EncryptUtil.encrypt(user.getPassword()));
                result = userMapper.selectByExample(example);
            }
            return result.size() > 0;
        } catch (Exception e) {
            LOG.info("userService checkIfCanLogin异常\n" + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean modifyInfo(User user) {
        int isSuccess = 0;
        try {
            if (user != null && !StringUtil.isEmpty(user.getUserName())) {
                UserExample example = new UserExample();
                example.or().andUserNameEqualTo(user.getUserName());
                isSuccess = userMapper.updateByExampleWithBLOBs(user, example);
            }
            return isSuccess > 0;
        } catch (Exception e) {
            LOG.info("userService modifyInfo异常\n" + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public PagedResult selectByExampleWithBLOBsByPage(UserExample example, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        return BeanUtil.toPagedResult(userMapper.selectByExampleWithBLOBs(example));
    }

    @Override
    public PagedResult selectByExampleByPage(UserExample example, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        return BeanUtil.toPagedResult(userMapper.selectByExample(example));
    }

    @Override
    public long countByExample(UserExample example) {
        return userMapper.countByExample(example);
    }

}
