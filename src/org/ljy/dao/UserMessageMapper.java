package org.ljy.dao;

import org.apache.ibatis.annotations.Param;
import org.ljy.common.Page;
import org.ljy.domain.UserMessage;
import org.ljy.domain.UserMessageExample;

import java.util.List;

public interface UserMessageMapper {

	long countByExample(UserMessageExample example);

	int deleteByExample(UserMessageExample example);

	int deleteByPrimaryKey(Long messageId);

	int insert(UserMessage record);

	int insertSelective(UserMessage record);

	List<UserMessage> selectByExample(UserMessageExample example);

	List<UserMessage> selectByExampleByPage(@Param("example") UserMessageExample example, @Param("page")Page page);

	UserMessage selectByPrimaryKey(Long messageId);

	int updateByExampleSelective(@Param("record") UserMessage record, @Param("example") UserMessageExample example);

	int updateByExample(@Param("record") UserMessage record, @Param("example") UserMessageExample example);

	int updateByPrimaryKeySelective(UserMessage record);

	int updateByPrimaryKey(UserMessage record);
}