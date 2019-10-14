package com.qiudaozhang.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qiudaozhang.dto.IDDto;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.dto.UserDto;
import com.qiudaozhang.mapper.DataDictionaryDao;
import com.qiudaozhang.mapper.RoleDao;
import com.qiudaozhang.mapper.UserDao;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.model.User;
import com.qiudaozhang.service.DataDictionaryService;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private DataDictionaryDao dictionaryDao;

    @Autowired
    private DataDictionaryService dictionaryService;
    @Override
    public void save(User user) {
        user.setPassword("123456");
        user.setPassword2("123456");
        user.setCreateTime(LocalDateTime.now());
        DataDictionary dictionary = dictionaryService.selectCardName("CARD_TYPE",user.getCardType());
        user.setCardTypeName(dictionary.getValueName());
        if(user.getRecommender().getUserName() != null){
            User u = userDao.selectUserName(user.getRecommender().getUserName());
            user.setReferCode(u.getLoginCode());
            user.setReferId(u.getId());
        }
        userDao.save(user);
    }

    @Override
    public User check(String loginCode) {
        return userDao.check(loginCode);
    }

    @Override
    public ResponseCode modifyPwd(UserDto userDto) {
        userDao.modifyPwd(userDto);
        ResponseCode code = new ResponseCode();
        code.setMsg("密码修改成功");
        code.setCode(ResponseCode.SUCCESS);
        return code;
    }

    @Override
    public ResponseCode modifyPwd2(UserDto userDto) {
        userDao.modifyPwd2(userDto);
        ResponseCode code = new ResponseCode();
        code.setMsg("2级密码修改成功");
        code.setCode(ResponseCode.SUCCESS);
        return code;
    }

    @Override
    public void modify(User user) {
        DataDictionary dictionary = dictionaryService.selectCardName("CARD_TYPE",user.getCardType());
        user.setCardTypeName(dictionary.getValueName());

        userDao.modify(user);
    }

    @Override
    public User selectInfo(String u) {
        return userDao.selectInfo(u);
    }

    @Override
    public ResponseCode queryAll(Integer pageSize, Integer pageNum, String loginCode) {
        ResponseCode code = new ResponseCode();
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userDao.queryAll(loginCode);
        PageInfo<User> p = new PageInfo<>(users);
        code.setCode(0);
        code.setCount(p.getTotal());
        code.setData(users);
        return code;
    }

    @Override
    public ResponseCode del(Integer id) {
        ResponseCode code = new ResponseCode();
        int num = userDao.del(id);
        if(num > 0){
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("删除成功");
        } else{
            code.setCode(ResponseCode.FAIL);
            code.setMsg("删除失败");
        }
        return code;
    }

    @Override
    public ResponseCode delGroup(IDDto idDto) {
        ResponseCode code = new ResponseCode();
        int num = userDao.delGroup(idDto.getIds());
        if(num>0){
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("删除成功");
        }else{
            code.setCode(ResponseCode.FAIL);
            code.setMsg("删除失败");
        }
        return code;
    }

    @Override
    public void add(User user) {
        String roleName = roleDao.findById(user.getRoleId());
        user.setRoleName(roleName);
        if(user.getRoleId() != 1){
            // 处理会员类型
            DataDictionary dictionary = dictionaryDao.selectCardName("USER_TYPE", user.getUserType());
            user.setUserTypeName(dictionary.getTypeName());
        } else {
            user.setUserType(null);
            user.setUserTypeName(null);
        }

        // 处理证件
        DataDictionary dictionary = dictionaryDao.selectCardName("CARD_TYPE", user.getCardType());
        user.setCardTypeName(dictionary.getValueName());
        // 处理推荐人
        user.setReferId(user.getRecommender().getId());
        user.setReferCode(user.getRecommender().getLoginCode());
        // 处理创建日期
        user.setCreateTime(LocalDateTime.now());
        user.setPassword("123456");
        user.setPassword2("123456");
        userDao.save(user);
    }

}
