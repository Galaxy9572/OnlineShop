package org.ljy.service;

import org.ljy.common.PagedResult;
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

    PagedResult selectByExampleWithBLOBsByPage(UserExample example, Integer pageNo, Integer pageSize );

    List<User> selectByExample(UserExample example);

    PagedResult selectByExampleByPage(UserExample example, Integer pageNo, Integer pageSize );

    User selectByPrimaryKey(Long userId);

    int updateByExampleSelective(User record, UserExample example);

    int updateByExampleWithBLOBs(User record, UserExample example);

    int updateByExample(User record, UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);
}
