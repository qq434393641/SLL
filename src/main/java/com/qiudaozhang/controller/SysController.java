package com.qiudaozhang.controller;


import com.qiudaozhang.components.FileConfig;
import com.qiudaozhang.dto.IDDto;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.Country;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.model.Role;
import com.qiudaozhang.model.User;
import com.qiudaozhang.service.CountryService;
import com.qiudaozhang.service.DataDictionaryService;
import com.qiudaozhang.service.RoleService;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("sys/u")
public class SysController {



    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private FileConfig fileConfig;

    @RequestMapping("to/list")
    public String toList(){
        return "sys/userList";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseCode list(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum,
                             @RequestParam(value = "loginCode",defaultValue = "") String loginCode){
        ResponseCode code  = userService.queryAll(pageSize,pageNum,loginCode);
        return code;
    }
    @RequestMapping("to/addUser")
    public String addList(Model model){
            // 获取所有的角色
            List<Role> roles = roleService.findAll();
            model.addAttribute("roles",roles);
            // 获取所有会员类型
            List<DataDictionary> userTypes = dataDictionaryService.findByTypeCode("USER_TYPE");
            model.addAttribute("userTypes",userTypes);
            // 获取所有证件类型
            List<DataDictionary> cardTypes = dataDictionaryService.findByTypeCode("CARD_TYPE");
            model.addAttribute("cardTypes",cardTypes);
            // 获取所有国家
            List<Country> countries = countryService.findAll();
            model.addAttribute("countries",countries);
        return "sys/addUser";
    }

    @RequestMapping("addUser")
    public String addUser(User user,
                          @RequestParam("idCardPicPosPathFile") MultipartFile idCardPicPosPathFile ,
                          @RequestParam("idCardPicNegPathFile") MultipartFile idCardPicNegPathFile ,
                          @RequestParam("bankPicPathFile") MultipartFile bankPicPathFile,
                          HttpSession session
    ){
        User sessionUser = (User) session.getAttribute("loginUser");
        // 处理文件上传
        File dest1  = new File(fileConfig.getUploadRootPath(),idCardPicPosPathFile.getOriginalFilename());
        File dest2  = new File(fileConfig.getUploadRootPath(),idCardPicNegPathFile.getOriginalFilename());
        File dest3  = new File(fileConfig.getUploadRootPath(),bankPicPathFile.getOriginalFilename());
        try {
            idCardPicPosPathFile.transferTo(dest1);
            idCardPicNegPathFile.transferTo(dest2);
            bankPicPathFile.transferTo(dest3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setIdCardPicPosPath(idCardPicPosPathFile.getOriginalFilename());
        user.setIdCardPicNegPath(idCardPicNegPathFile.getOriginalFilename());
        user.setBankPicPath(bankPicPathFile.getOriginalFilename());
        user.setRecommender(sessionUser);
        userService.add(user);
        return "main";
    }
    @RequestMapping("delGroup")
    @ResponseBody
    public ResponseCode delGroup(@RequestBody IDDto idDto){
        ResponseCode code = userService.delGroup(idDto);
        return code;
    }
}
