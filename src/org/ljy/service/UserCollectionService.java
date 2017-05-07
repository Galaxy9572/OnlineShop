package org.ljy.service;

import org.ljy.common.PagedResult;
import org.ljy.domain.UserCollection;
import org.ljy.domain.UserCollectionExample;

import java.util.List;

/**
 * Created by ljy56 on 2017/4/19.
 */
public interface UserCollectionService {
    long countByExample(UserCollectionExample example);

    int deleteByExample(UserCollectionExample example);

    int deleteByPrimaryKey(Long collectionId);

    int insert(UserCollection record);

    int insertSelective(UserCollection record);

    List<UserCollection> selectByExample(UserCollectionExample example);

    PagedResult selectByExampleByPage(UserCollectionExample example, Integer pageNo, Integer pageSize);

    UserCollection selectByPrimaryKey(Long collectionId);

    int updateByExampleSelective(UserCollection record,UserCollectionExample example);

    int updateByExample(UserCollection record,UserCollectionExample example);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);
}
