package org.ljy.service;

import org.ljy.domain.UserExample;

/**
 * Created by ljy56 on 2017/5/9.
 */
public interface AdminService {

    boolean deleteUser(UserExample example);

    boolean deleteUsers(UserExample example);

}
