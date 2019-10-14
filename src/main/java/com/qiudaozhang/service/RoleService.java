package com.qiudaozhang.service;

import com.qiudaozhang.dto.IDDto;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    ResponseCode delGroup(IDDto idDto);
}
