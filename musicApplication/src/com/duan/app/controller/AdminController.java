package com.duan.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.duan.app.entity.Admin;
import com.duan.app.service.AdminService;

/**
 * 
 * @ClassName:AdminController.java
 * @Description:管理员Controller
 * @author duan
 * @Time 2019年5月21日下午9:58:57
 * 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping("/selectAdminByName")
    public String selectAdminByName(Model model, Admin admin) throws Exception {

	List<Admin> adminList = adminService.selectAdminByName(admin);

	model.addAttribute("adminList", adminList);

	return null;
    }

    @RequestMapping("/editAdmin")
    public String editAdmin(Model model, Integer id) throws Exception {

	Admin admin = adminService.findAdminById(id);

	model.addAttribute("admin", admin);

	return null;
    }

    @RequestMapping("/editAdminSubmit")
    public String editAdminSubmit(Model model, Integer id, Admin admin) throws Exception {

	adminService.updateAdmin(id, admin);

	return null;
    }

    @RequestMapping("/deleteAdmin")
    public String deleteAdmin(Integer[] id) throws Exception {

	adminService.deleteAdmin(id);

	return null;
    }

    @RequestMapping("/insertAdmin")
    public String insertAdmin(Admin admin) throws Exception {

	adminService.insertAdmin(admin);

	return null;
    }

    @RequestMapping("/login")
    public @ResponseBody Admin loginAdmin(HttpSession session, Admin admin) throws Exception {

	Admin admin2 = adminService.login(admin);

	if (admin2 != null) {
	    session.setAttribute("adminname", admin2.getAdminname());
	}

	return adminService.login(admin);
    }

}
