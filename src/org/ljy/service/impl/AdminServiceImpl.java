package org.ljy.service.impl;

import org.apache.log4j.Logger;
import org.ljy.dao.GoodsMapper;
import org.ljy.dao.ShopMapper;
import org.ljy.dao.UserMapper;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;
import org.ljy.enums.UserType;
import org.ljy.service.AdminService;
import org.ljy.util.EncryptUtil;
import org.ljy.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ljy56 on 2017/5/9.
 */
@Service
public class AdminServiceImpl implements AdminService {
    private static Logger LOG = Logger.getLogger(AdminServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    @Resource
    private ShopMapper shopMapper;

    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public boolean addAdmin(User user) {
        int flag;
        try {
            if (user != null && StringUtil.isNotNullAndNotEmpty(user.getUserName())) {
                Date date = new Date();
                user.setPassword(EncryptUtil.encrypt(user.getPassword()));
                user.setUserType(UserType.ADMIN.key());
                user.setRegTime(date);
                user.setModifyTime(date);
                flag = userMapper.insertSelective(user);
            }else{
                flag = 0;
            }
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(), e);
            return false;
        }
    }

    @Override
    public boolean deleteUser(UserExample example) {
        int flag = userMapper.deleteByExample(example);
        return flag > 0;
    }

    @Override
    public boolean deleteUsers(UserExample example) {
        return false;
    }

    @Override
    public boolean deleteShopById(Long id) {
        Long userId = shopMapper.selectByPrimaryKey(id).getUserId();
        User user = new User();
        user.setUserId(userId);
        user.setUserType(UserType.BUYER.key());
        int flag1 = userMapper.updateByPrimaryKeySelective(user);
        int flag2 = shopMapper.deleteByPrimaryKey(id);
        return flag1 > 0 && flag2 > 0;
    }

    @Override
    public boolean deleteGoodsById(Long id) {
        int flag = goodsMapper.deleteByPrimaryKey(id);
        return flag > 0;
    }


}
