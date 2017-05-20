package org.ljy.service;

import org.ljy.common.PagedResult;
import org.ljy.domain.UserMessage;
import org.ljy.domain.UserMessageExample;

/**
 * Created by ljy56 on 2017/4/19.
 */
public interface UserMessageService {
    long countByExample(UserMessageExample example);

    boolean sendMessage(UserMessage message);

    boolean deleteMessageByMessage(Long messageId);

    boolean updateMessage(UserMessage message);

    PagedResult queryMsgByCondition(String userId,String statement, Integer pageNo, Integer pageSize);
}
