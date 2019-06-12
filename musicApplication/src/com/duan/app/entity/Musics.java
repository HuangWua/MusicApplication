package com.duan.app.entity;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Musics {
    private Integer id;

    // 歌名：在1到30个字符
    @Size(min = 1, max = 30, message = "{musics.name.length.error}")
    // 歌名不为空
    @NotNull(message = "{musics.name.isNull}")
    private String name;

    // 风格非空校验
    @NotNull(message = "{musics.typename.isNull}")
    private String typename;

    // 歌手名：在1到30个字符
    @Size(min = 1, max = 30, message = "{musics.singerName.length.error}")
    // 歌手名不为空
    @NotNull(message = "{musics.singerName.isNull}")
    private String singername;

    private String url;

    // 创建日期不为空
    @NotNull(message = "{musics.createtime.isNull}")
    private Date createtime;

    private String detail;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name == null ? null : name.trim();
    }

    public String getTypename() {
	return typename;
    }

    public void setTypename(String typename) {
	this.typename = typename == null ? null : typename.trim();
    }

    public String getSingername() {
	return singername;
    }

    public void setSingername(String singername) {
	this.singername = singername == null ? null : singername.trim();
    }

    public String getUrl() {
	return url;
    }

    public void setUrl(String url) {
	this.url = url == null ? null : url.trim();
    }

    public Date getCreatetime() {
	return createtime;
    }

    public void setCreatetime(Date createtime) {
	this.createtime = createtime;
    }

    public String getDetail() {
	return detail;
    }

    public void setDetail(String detail) {
	this.detail = detail == null ? null : detail.trim();
    }
}