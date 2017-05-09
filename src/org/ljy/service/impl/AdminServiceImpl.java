package org.ljy.service.impl;

import org.apache.log4j.Logger;
import org.ljy.dao.UserMapper;
import org.ljy.domain.UserExample;
import org.ljy.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ljy56 on 2017/5/9.
 */
@Service
public class AdminServiceImpl implements AdminService {
    private static Logger LOG = Logger.getLogger(AdminServiceImpl.class);
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean deleteUser(UserExample example) {
        boolean bool = false;
        int flag = userMapper.deleteByExample(example);
        if(flag > 0){
            bool = true;
        }
        return bool;
    }

    @Override
    public boolean deleteUsers(UserExample example) {
        return false;
    }
}
