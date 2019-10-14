package com.qiudaozhang.service.impl;

import com.qiudaozhang.dto.IDDto;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.mapper.RoleDao;
import com.qiudaozhang.model.Role;
import com.qiudaozhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public ResponseCode delGroup(IDDto idDto) {
        int num = roleDao.delGroup(idDto.getIds());
        ResponseCode code = new ResponseCode();
        if(num > 0){
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("删除成功");
        }else{
            code.setCode(ResponseCode.FAIL);
            code.setMsg("删除失败");
        }
        return code;
    }
}
