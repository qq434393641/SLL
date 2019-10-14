package com.qiudaozhang.mapper;

import com.qiudaozhang.model.Affiche;

public interface AfficheDao {
    int deleteByPrimaryKey(Long id);

    int insert(Affiche record);

    int insertSelective(Affiche record);

    Affiche selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Affiche record);

    int updateByPrimaryKeyWithBLOBs(Affiche record);

    int updateByPrimaryKey(Affiche record);
}