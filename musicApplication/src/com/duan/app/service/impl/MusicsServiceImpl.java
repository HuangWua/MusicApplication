package com.duan.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.duan.app.entity.Musics;
import com.duan.app.entity.MusicsExample;
import com.duan.app.entity.MusicsExample.Criteria;
import com.duan.app.mapper.MusicsMapper;
import com.duan.app.service.MusicsService;

/**
 * 
 * @ClassName:MusicsServiceImpl.java
 * @Description:歌曲Service实现类
 * @author duan
 * @Time 2019年5月21日下午10:18:45
 * 
 */
@Service
public class MusicsServiceImpl implements MusicsService {

    @Autowired
    private MusicsMapper musicsMapper;

    @Override
    public Musics findMusicsById(Integer id) throws Exception {

	return musicsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Musics> selectMusicsByName(Musics musics) throws Exception {

	MusicsExample example = new MusicsExample();
	Criteria criteria = example.createCriteria();
	criteria.andNameLike("%" + (musics.getName() == null ? "" : musics.getName()) + "%");
	example.setOrderByClause("id ASC");
	List<Musics> musicsList = musicsMapper.selectByExample(example);

	return musicsList;
    }

    @Override
    public void updateMusics(Integer id, Musics musics) throws Exception {

	musics.setId(id);

	int result = musicsMapper.updateByPrimaryKeyWithBLOBs(musics);
	System.out.println(result);

    }

    @Override
    public void insertMusics(Musics musics) throws Exception {
	int result = musicsMapper.insert(musics);
	System.out.println(result);
    }

    @Override
    public void deleteMusics(Integer[] id) throws Exception {
	Boolean result = false;
	for (Integer integer : id) {
	    result = musicsMapper.deleteByPrimaryKey(integer) > 0 ? true : false;
	}
	System.out.println(result);
    }

}
