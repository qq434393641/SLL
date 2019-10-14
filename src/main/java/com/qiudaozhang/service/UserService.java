package com.qiudaozhang.service;

import com.qiudaozhang.dto.IDDto;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.dto.UserDto;
import com.qiudaozhang.model.User;

public interface UserService {
    void save(User user);

    User check(String loginCode);

    ResponseCode modifyPwd(UserDto userDto);

    ResponseCode modifyPwd2(UserDto userDto);

    void modify(User user);

    User selectInfo(String u);

    ResponseCode queryAll(Integer pageSize, Integer pageNum, String loginCode);

    ResponseCode del(Integer id);

    ResponseCode delGroup(IDDto idDto);

    void add(User user);
}
