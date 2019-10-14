package com.qiudaozhang.mapper;

import com.qiudaozhang.dto.UserDto;
import com.qiudaozhang.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    void save(User user);

    User selectUserName(@Param("userName") String userName);

    User check(@Param("loginCode") String loginCode);

    void modifyPwd(UserDto userDto);

    void modifyPwd2(UserDto userDto);

    void modify(User user);

    User selectInfo(@Param("u") String u);

    List<User> queryAll(String loginCode);

    int del(@Param("id") Integer id);

    int delGroup(List<Integer> ids);


}