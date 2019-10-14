package com.qiudaozhang.mapper;

import com.qiudaozhang.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao {

    List<Role> findAll();

    String findById(@Param("roleId") Long roleId);

    void save(Role role);

    int delGroup(List<Integer> ids);
}