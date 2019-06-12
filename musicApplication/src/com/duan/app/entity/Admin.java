package com.duan.app.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Admin {
    private Integer adminid;

    // 用户名：在1到20个字符
    @Size(min = 1, max = 20, message = "{admin.adminname.length.error}")
    // 用户名不为空
    @NotNull(message = "{admin.adminname.isNull}")
    private String adminname;

    // 密码：在1到20个字符
    @Size(min = 1, max = 20, message = "{admin.adminpwd.length.error}")
    // 密码不为空
    @NotNull(message = "{admin.adminpwd.isNull}")
    private String adminpwd;

    public Integer getAdminid() {
	return adminid;
    }

    public void setAdminid(Integer adminid) {
	this.adminid = adminid;
    }

    public String getAdminname() {
	return adminname;
    }

    public void setAdminname(String adminname) {
	this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getAdminpwd() {
	return adminpwd;
    }

    public void setAdminpwd(String adminpwd) {
	this.adminpwd = adminpwd == null ? null : adminpwd.trim();
    }
}