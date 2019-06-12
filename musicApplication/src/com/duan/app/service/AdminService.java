package com.duan.app.service;

import java.util.List;

import com.duan.app.entity.Admin;

/**
 * 
 * @ClassName:AdminService.java
 * @Description:管理员Service
 * @author duan
 * @Time 2019年5月21日下午9:59:44
 * 
 */

public interface AdminService {

    // id查询Admin
    public Admin findAdminById(Integer id) throws Exception;

    // 管理员模糊查询
    public List<Admin> selectAdminByName(Admin admin) throws Exception;

    // 更新管理员信息
    public void updateAdmin(Integer id, Admin admin) throws Exception;

    // 添加Admin信息
    public void insertAdmin(Admin admin) throws Exception;

    // 删除
    public void deleteAdmin(Integer[] id) throws Exception;

    // 登入
    public Admin login(Admin admin) throws Exception;

}
