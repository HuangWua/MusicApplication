package com.duan.app.mapper;

import com.duan.app.entity.Musics;
import com.duan.app.entity.MusicsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MusicsMapper {
    int countByExample(MusicsExample example);

    int deleteByExample(MusicsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Musics record);

    int insertSelective(Musics record);

    List<Musics> selectByExampleWithBLOBs(MusicsExample example);

    List<Musics> selectByExample(MusicsExample example);

    Musics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Musics record, @Param("example") MusicsExample example);

    int updateByExampleWithBLOBs(@Param("record") Musics record, @Param("example") MusicsExample example);

    int updateByExample(@Param("record") Musics record, @Param("example") MusicsExample example);

    int updateByPrimaryKeySelective(Musics record);

    int updateByPrimaryKeyWithBLOBs(Musics record);

    int updateByPrimaryKey(Musics record);
}