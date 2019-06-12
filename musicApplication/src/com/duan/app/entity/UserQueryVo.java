package com.duan.app.entity;

import java.util.List;

/**
 * 
 * @ClassName: UserQueryVo.java
 * @Description: TODO
 * @author duan
 * @Time 2019年5月20日下午4:59:42
 *
 */

public class UserQueryVo {

	// 用户信息
	private User user;
	// 扩展的用户信息po
	private UserCustom userCustom;
	// 批量用户信息
	private List<UserCustom> userList;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserCustom getUserCustom() {
		return userCustom;
	}

	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}

	public List<UserCustom> getUserList() {
		return userList;
	}

	public void setUserList(List<UserCustom> userList) {
		this.userList = userList;
	}

}
