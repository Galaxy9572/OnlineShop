package org.ljy.dao;

import org.apache.ibatis.annotations.Param;
import org.ljy.common.Page;
import org.ljy.domain.UserCollection;
import org.ljy.domain.UserCollectionExample;
import org.ljy.domain.UserMessage;
import org.ljy.domain.UserMessageExample;

import java.util.List;

public interface UserCollectionMapper {

	long countByExample(UserCollectionExample example);

	int deleteByExample(UserCollectionExample example);

	int deleteByPrimaryKey(Long collectionId);

	int insert(UserCollection record);

	int insertSelective(UserCollection record);

	List<UserCollection> selectByExample(UserCollectionExample example);

	List<UserMessage> selectByExampleByPage(@Param("example") UserMessageExample example, @Param("page")Page page);

	UserCollection selectByPrimaryKey(Long collectionId);

	int updateByExampleSelective(@Param("record") UserCollection record,
                                 @Param("example") UserCollectionExample example);

	int updateByExample(@Param("record") UserCollection record, @Param("example") UserCollectionExample example);

	int updateByPrimaryKeySelective(UserCollection record);

	int updateByPrimaryKey(UserCollection record);
}