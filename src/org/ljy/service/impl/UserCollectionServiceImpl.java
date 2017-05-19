package org.ljy.service.impl;

import org.ljy.dao.UserCollectionMapper;
import org.ljy.domain.UserCollection;
import org.ljy.domain.UserCollectionExample;
import org.ljy.service.UserCollectionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by ljy56 on 2017/4/19.
 */
@Service("userCollectionService")
public class UserCollectionServiceImpl implements UserCollectionService {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Resource
    private UserCollectionMapper userCollectionMapper;

    @Override
    public long countByExample(UserCollectionExample example) {
        return userCollectionMapper.countByExample(example);
    }

    @Override
    public boolean collect(UserCollection userCollection) {
        try {
            Date date = new Date();
            userCollection.setCreateTime(date);
            userCollection.setModifyTime(date);
            int flag = userCollectionMapper.insertSelective(userCollection);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }

    @Override
    public boolean removeCollection(Long collectionId) {
        try {
            int flag = userCollectionMapper.deleteByPrimaryKey(collectionId);
            return flag > 0;
        } catch (Exception e) {
            LOG.warn(e.getMessage(),e);
            return false;
        }
    }
}
