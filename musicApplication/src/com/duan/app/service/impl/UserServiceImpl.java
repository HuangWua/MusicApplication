package com.duan.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duan.app.entity.User;
import com.duan.app.entity.UserExample;
import com.duan.app.entity.UserExample.Criteria;
import com.duan.app.entity.UserQueryVo;
import com.duan.app.mapper.UserMapper;
import com.duan.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    // @Autowired
    // private UserMapperCustom userMapperCustom;

    @Autowired
    private UserMapper userMapper;

    public List<User> findUserList(UserQueryVo userQueryVo) throws Exception {

	UserExample example = new UserExample();
	Criteria criteria = example.createCriteria();
	String value = userQueryVo.getUserCustom() == null ? "" : userQueryVo.getUserCustom().getName();
	criteria.andNameLike("%" + value + "%");
	example.setOrderByClause("id DESC");

	return userMapper.selectByExample(example);

	// return userMapperCustom.findUserList(userQueryVo);

    }

}
