package com.duan.app.mapper;

import java.util.List;

import com.duan.app.entity.UserCustom;
import com.duan.app.entity.UserQueryVo;

/**
 * 
 * @ClassName:UserMapperCustom.java
 * @Description:TODO
 * @author duan
 * @Time 2019年5月20日下午5:26:47
 * 
 */

public interface UserMapperCustom {
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
}
