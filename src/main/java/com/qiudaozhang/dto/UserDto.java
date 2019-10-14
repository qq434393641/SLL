package com.qiudaozhang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    private String loginCode;
    private String oldPwd;
    private String newPwd;
    private String oldPwd2;
    private String newPwd2;

}
