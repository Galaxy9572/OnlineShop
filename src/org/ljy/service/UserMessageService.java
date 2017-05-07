package org.ljy.service;

import org.ljy.common.PagedResult;
import org.ljy.domain.UserMessage;
import org.ljy.domain.UserMessageExample;

import java.util.List;

/**
 * Created by ljy56 on 2017/4/19.
 */
public interface UserMessageService {
    long countByExample(UserMessageExample example);

    int deleteByExample(UserMessageExample example);

    int deleteByPrimaryKey(Long messageId);

    int insert(UserMessage record);

    int insertSelective(UserMessage record);

    List<UserMessage> selectByExample(UserMessageExample example);

    PagedResult selectByExampleByPage(UserMessageExample example, Integer pageNo, Integer pageSize);

    UserMessage selectByPrimaryKey(Long messageId);

    int updateByExampleSelective(UserMessage record, UserMessageExample example);

    int updateByExample(UserMessage record, UserMessageExample example);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
}
