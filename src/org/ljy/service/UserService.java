package org.ljy.service;

import org.ljy.common.Page;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;

import java.util.List;

/**
 * User接口
 * 
 * @author 廖俊瑶 2016年12月10日
 */
public interface UserService {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExampleWithBLOBs(UserExample example);

    List<User> selectByExampleWithBLOBsByPage(UserExample example, Page page);

    List<User> selectByExample(UserExample example);

    List<User> selectByExampleByPage(UserExample example,Page page);

    User selectByPrimaryKey(Long userId);

    int updateByExampleSelective(User record, UserExample example);

    int updateByExampleWithBLOBs(User record, UserExample example);

    int updateByExample(User record, UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}
