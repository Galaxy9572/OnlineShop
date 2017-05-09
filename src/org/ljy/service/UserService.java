package org.ljy.service;

import org.ljy.common.PagedResult;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;

/**
 * User接口
 * 
 * @author 廖俊瑶 2016年12月10日
 */
public interface UserService {
    User userRegister(User user);

    User userLogin(User user);

    boolean checkIfCanReg(User user);

    boolean checkIfCanLogin(User user);

    boolean modifyInfo(User user);

    PagedResult selectByExampleWithBLOBsByPage(UserExample example, Integer pageNo, Integer pageSize );

    PagedResult selectByExampleByPage(UserExample example, Integer pageNo, Integer pageSize );

    long countByExample(UserExample example);
}
