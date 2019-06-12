package com.duan.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.duan.app.entity.User;
import com.duan.app.entity.UserCustom;
import com.duan.app.entity.UserQueryVo;
import com.duan.app.service.UserService;

/**
 * 
 * @ClassName: UserController.java
 * @Description: User控制器
 * @author duan
 * @Time   2019年5月21日上午10:38:43
 *
 */

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("/findUserList")
	public ModelAndView findUserList(UserQueryVo userQueryVo) throws Exception {

		List<User> userList = userService.findUserList(userQueryVo);

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("userList", userList);

		modelAndView.setViewName("show");

		return modelAndView;

	}

}
