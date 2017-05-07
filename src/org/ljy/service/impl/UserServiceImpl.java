package org.ljy.service.impl;

import com.github.pagehelper.PageHelper;
import org.ljy.common.PagedResult;
import org.ljy.dao.UserMapper;
import org.ljy.domain.User;
import org.ljy.domain.UserExample;
import org.ljy.service.UserService;
import org.ljy.util.BeanUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;

	@Override
	public long countByExample(UserExample example) {
		return userMapper.countByExample(example);
	}

	@Override
	public int deleteByExample(UserExample example) {
		return userMapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(Long userId) {
		return userMapper.deleteByPrimaryKey(userId);
	}

	@Override
	public int insert(User record) {
		return userMapper.insert(record);
	}

	@Override
	public int insertSelective(User record) {
		return userMapper.insertSelective(record);
	}

	@Override
	public List<User> selectByExampleWithBLOBs(UserExample example) {
		return userMapper.selectByExampleWithBLOBs(example);
	}

	@Override
	public PagedResult selectByExampleWithBLOBsByPage(UserExample example, Integer pageNo, Integer pageSize ) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
		return BeanUtil.toPagedResult(userMapper.selectByExampleWithBLOBs(example));
	}

	@Override
	public List<User> selectByExample(UserExample example) {
		return userMapper.selectByExample(example);
	}

	@Override
	public PagedResult selectByExampleByPage(UserExample example, Integer pageNo, Integer pageSize ) {
		pageNo = pageNo == null?1:pageNo;
		pageSize = pageSize == null?10:pageSize;
		PageHelper.startPage(pageNo,pageSize);
		return BeanUtil.toPagedResult(userMapper.selectByExample(example));
	}

	@Override
	public User selectByPrimaryKey(Long userId) {
		return userMapper.selectByPrimaryKey(userId);
	}

	@Override
	public int updateByExampleSelective(User record, UserExample example) {
		return userMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExampleWithBLOBs(User record, UserExample example) {
		return userMapper.updateByExampleSelective(record, example);
	}

	@Override
	public int updateByExample(User record, UserExample example) {
		return userMapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(User record) {
		return userMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(User record) {
		return userMapper.updateByPrimaryKey(record);
	}
}
