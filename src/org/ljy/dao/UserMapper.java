package org.ljy.dao;

import org.apache.ibatis.annotations.Param;
import org.ljy.common.Page;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;

import java.util.List;

public interface UserMapper {

	long countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Long userId);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExampleWithBLOBs(UserExample example);

	List<User> selectByExampleWithBLOBsByPage(@Param("example") UserExample example,@Param("page") Page page);

	List<User> selectByExample(UserExample example);

	List<User> selectByExampleByPage(@Param("example") UserExample example,@Param("page") Page page);

	User selectByPrimaryKey(Long userId);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExampleWithBLOBs(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKeyWithBLOBs(User record);

	int updateByPrimaryKey(User record);
}