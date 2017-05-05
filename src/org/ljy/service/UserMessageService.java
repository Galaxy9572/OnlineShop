package org.ljy.service;

import org.ljy.common.Page;
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

    List<UserMessage> selectByExampleByPage(UserMessageExample example,Page page);

    UserMessage selectByPrimaryKey(Long messageId);

    int updateByExampleSelective(UserMessage record, UserMessageExample example);

    int updateByExample(UserMessage record, UserMessageExample example);

    int updateByPrimaryKeySelective(UserMessage record);

    int updateByPrimaryKey(UserMessage record);
}
