package com.qiudaozhang.controller;

import com.qiudaozhang.dto.IDDto;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.Role;
import com.qiudaozhang.model.User;
import com.qiudaozhang.service.RoleService;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("to/roleList")
    public String toRoleList(){
        return "role/roleList";
    }

    @RequestMapping("roleList")
    @ResponseBody
    public ResponseCode list(){
        ResponseCode code = new ResponseCode();
        code.setData(roleService.findAll());
        code.setCode(0);
        return code;
    }
    @RequestMapping("to/addRole")
    public String toAddRole(){
        return "role/addRole";
    }

    @RequestMapping("addRole")
    public String addRole(Role role, HttpSession session){
        User sessionUser = (User) session.getAttribute("loginUser");
        role.setCreatedBy(sessionUser.getLoginCode());
        role.setCreateDate(LocalDate.now());
        roleService.save(role);
        return "role/roleList";
    }

    @RequestMapping("delGroup")
    @ResponseBody
    public ResponseCode delGroup(@RequestBody IDDto idDto){
        ResponseCode code = roleService.delGroup(idDto);
        return code;
    }

}
