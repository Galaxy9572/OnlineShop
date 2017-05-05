package org.ljy.service.impl;

import org.ljy.common.Page;
import org.ljy.dao.UserMessageMapper;
import org.ljy.domain.UserMessage;
import org.ljy.domain.UserMessageExample;
import org.ljy.service.UserMessageService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ljy56 on 2017/4/19.
 */
public class UserMessageServiceImpl implements UserMessageService {
    @Resource
    private UserMessageMapper userMessageMapper;
    @Override
    public long countByExample(UserMessageExample example) {
        return userMessageMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserMessageExample example) {
        return userMessageMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long messageId) {
        return userMessageMapper.deleteByPrimaryKey(messageId);
    }

    @Override
    public int insert(UserMessage record) {
        return userMessageMapper.insert(record);
    }

    @Override
    public int insertSelective(UserMessage record) {
        return userMessageMapper.insertSelective(record);
    }

    @Override
    public List<UserMessage> selectByExample(UserMessageExample example) {
        return userMessageMapper.selectByExample(example);
    }

    @Override
    public List<UserMessage> selectByExampleByPage(UserMessageExample example, Page page) {
        return userMessageMapper.selectByExampleByPage(example, page);
    }

    @Override
    public UserMessage selectByPrimaryKey(Long messageId) {
        return userMessageMapper.selectByPrimaryKey(messageId);
    }

    @Override
    public int updateByExampleSelective(UserMessage record, UserMessageExample example) {
        return userMessageMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByExample(UserMessage record, UserMessageExample example) {
        return userMessageMapper.updateByExampleSelective(record,example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserMessage record) {
        return userMessageMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserMessage record) {
        return userMessageMapper.updateByPrimaryKey(record);
    }
}
