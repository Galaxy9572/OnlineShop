package org.ljy.service;

import org.ljy.common.Page;
import org.ljy.domain.UserCollection;
import org.ljy.domain.UserCollectionExample;
import org.ljy.domain.UserMessage;
import org.ljy.domain.UserMessageExample;

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

    List<UserMessage> selectByExampleByPage(UserMessageExample example,Page page);

    UserCollection selectByPrimaryKey(Long collectionId);

    int updateByExampleSelective(UserCollection record,UserCollectionExample example);

    int updateByExample(UserCollection record,UserCollectionExample example);

    int updateByPrimaryKeySelective(UserCollection record);

    int updateByPrimaryKey(UserCollection record);
}
