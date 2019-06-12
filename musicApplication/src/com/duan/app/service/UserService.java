package com.duan.app.service;

import java.util.List;

import com.duan.app.entity.User;
import com.duan.app.entity.UserQueryVo;

public interface UserService {
	
	//模糊查询
	public List<User> findUserList(UserQueryVo userQueryVo) throws Exception;
	
}
