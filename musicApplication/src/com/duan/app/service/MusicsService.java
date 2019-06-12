package com.duan.app.service;

import java.util.List;

import com.duan.app.entity.Musics;

/**
 * 
 * @ClassName:MusicsService.java
 * @Description:歌曲Service
 * @author duan
 * @Time 2019年5月21日下午10:14:55
 * 
 */

public interface MusicsService {

	// id查询Musics
	public Musics findMusicsById(Integer id) throws Exception;

	// Musics模糊查询
	public List<Musics> selectMusicsByName(Musics musics) throws Exception;

	// 更新Musics信息
	public void updateMusics(Integer id, Musics musics) throws Exception;

	// 添加Musics信息
	public void insertMusics(Musics musics) throws Exception;

	// 删除Musics
	public void deleteMusics(Integer[] id) throws Exception;

}
