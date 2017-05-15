package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.ljy.common.PagedResult;
import org.ljy.dao.UserMessageMapper;
import org.ljy.domain.UserMessage;
import org.ljy.domain.UserMessageExample;
import org.ljy.service.UserMessageService;
import org.ljy.util.BeanUtil;
import org.ljy.util.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ljy56 on 2017/4/19.
 */
@Service("userMessageService")
public class UserMessageServiceImpl implements UserMessageService {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserMessageMapper userMessageMapper;
    @Override
    public long countByExample(UserMessageExample example) {
        return userMessageMapper.countByExample(example);
    }

    @Override
    public boolean sendMessage(UserMessage message) {
        try {
            int flag = userMessageMapper.insertSelective(message);
            return flag > 0;
        } catch (DataAccessException e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public boolean deleteMessageByUserId(Long messageId) {
        try {
            int flag = userMessageMapper.deleteByPrimaryKey(messageId);
            return flag > 0;
        } catch (DataAccessException e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public boolean updateMessage(UserMessage message) {
        try {
            int flag = userMessageMapper.updateByPrimaryKey(message);
            return flag > 0;
        } catch (DataAccessException e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public PagedResult queryMsgByCondition(String userId,String statement, Integer pageNo, Integer pageSize) {
        UserMessageExample example = new UserMessageExample();
        List<UserMessage> result;
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        try {
            if(StringUtil.isNotNullAndNotEmpty(userId)){
                long userIdLong = Long.parseLong(userId);
                example.or().andUserIdEqualTo(userIdLong);
            }
            int statementInt = Integer.parseInt(statement);
            switch (statementInt){
                case 0:
                    result = userMessageMapper.selectByExample(example);
                    break;
                default:
                    example.or().andStatementEqualTo(statementInt);
                    result = userMessageMapper.selectByExample(example);
                    break;
            }
            return BeanUtil.toPagedResult(result);
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return null;
        }
    }
}
