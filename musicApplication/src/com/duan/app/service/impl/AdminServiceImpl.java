package com.duan.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duan.app.entity.Admin;
import com.duan.app.entity.AdminExample;
import com.duan.app.entity.AdminExample.Criteria;
import com.duan.app.mapper.AdminMapper;
import com.duan.app.service.AdminService;

/**
 * 
 * @ClassName:AdminServiceImpl.java
 * @Description:管理员Service实现类
 * @author duan
 * @Time 2019年5月21日下午10:18:02
 * 
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminById(Integer id) throws Exception {

	return adminMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Admin> selectAdminByName(Admin admin) throws Exception {

	AdminExample example = new AdminExample();
	Criteria criteria = example.createCriteria();
	criteria.andAdminnameLike("%" + (admin.getAdminname() == null ? "" : admin.getAdminname()) + "%");
	example.setOrderByClause("AdminID ASC");

	List<Admin> adminList = adminMapper.selectByExample(example);

	return adminList;
    }

    @Override
    public void updateAdmin(Integer id, Admin admin) throws Exception {
	admin.setAdminid(id);
	int result = adminMapper.updateByPrimaryKey(admin);
	System.out.println(result);
    }

    @Override
    public void insertAdmin(Admin admin) throws Exception {
	int result = adminMapper.insert(admin);
	System.out.println(result);
    }

    @Override
    public void deleteAdmin(Integer[] id) throws Exception {
	Boolean result = false;
	for (Integer integer : id) {
	    result = adminMapper.deleteByPrimaryKey(integer) > 0 ? true : false;
	}
	System.out.println(result);
    }

    @Override
    public Admin login(Admin admin) throws Exception {
	AdminExample example = new AdminExample();
	Criteria criteria = example.createCriteria();
//	criteria.andAdminnameLike("%" + (admin.getAdminname()) + "%");
	criteria.andAdminnameEqualTo(admin.getAdminname().trim());

	List<Admin> admins = adminMapper.selectByExample(example);

	if (admins.size() > 0) {
	    for (Admin admin2 : admins) {
		if (admin.getAdminpwd().equals(admin2.getAdminpwd())) {
		    return admin2;
		}
	    }
	}

	return null;
    }

}
