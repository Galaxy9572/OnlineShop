package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.ljy.common.PagedResult;
import org.ljy.dao.UserCollectionMapper;
import org.ljy.domain.UserCollection;
import org.ljy.domain.UserCollectionExample;
import org.ljy.service.UserCollectionService;
import org.ljy.util.BeanUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ljy56 on 2017/4/19.
 */
public class UserCollectionServiceImpl implements UserCollectionService {
    @Resource
    private UserCollectionMapper userCollectionMapper;
    @Override
    public long countByExample(UserCollectionExample example) {
        return userCollectionMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(UserCollectionExample example) {
        return userCollectionMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long collectionId) {
        return userCollectionMapper.deleteByPrimaryKey(collectionId);
    }

    @Override
    public int insert(UserCollection record) {
        return userCollectionMapper.insert(record);
    }

    @Override
    public int insertSelective(UserCollection record) {
        return userCollectionMapper.insertSelective(record);
    }

    @Override
    public List<UserCollection> selectByExample(UserCollectionExample example) {
        return userCollectionMapper.selectByExample(example);
    }

    @Override
    public PagedResult selectByExampleByPage(UserCollectionExample example, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?10:pageSize;
        PageHelper.startPage(pageNo,pageSize);
        return BeanUtil.toPagedResult(userCollectionMapper.selectByExample(example));
    }

    @Override
    public UserCollection selectByPrimaryKey(Long collectionId) {
        return userCollectionMapper.selectByPrimaryKey(collectionId);
    }

    @Override
    public int updateByExampleSelective(UserCollection record, UserCollectionExample example) {
        return userCollectionMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(UserCollection record, UserCollectionExample example) {
        return userCollectionMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(UserCollection record) {
        return userCollectionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserCollection record) {
        return userCollectionMapper.updateByPrimaryKey(record);
    }
}
