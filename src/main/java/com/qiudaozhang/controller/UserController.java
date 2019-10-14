package com.qiudaozhang.controller;

import com.qiudaozhang.components.FileConfig;
import com.qiudaozhang.dto.IDDto;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.dto.UserDto;
import com.qiudaozhang.model.Country;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.model.User;
import com.qiudaozhang.service.CountryService;
import com.qiudaozhang.service.DataDictionaryService;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("u")
public class UserController {

    @Autowired
    private FileConfig fileConfig;
    @Autowired
    private UserService userService;
    @Autowired
    private DataDictionaryService dictionaryService;
    @Autowired
    private CountryService countryService;

    @RequestMapping("login")
    public String login(HttpSession session,User user){
        User u = userService.check(user.getLoginCode());
        if(u == null){
            //用户名错误
            return "u/login";
        }else if(user.getPassword().equals(u.getPassword())){
            //用户名和密码正确
            session.setAttribute("loginUser",u);
            return "main";
        }else{
            //密码错误
            return "u/login";
        }
    }

    @RequestMapping("to/register")
    public String toRegister(Model model){
        //查询数据字典里面的卡的类型
        List<DataDictionary> dataDictionaries = dictionaryService.findByTypeCode("CARD_TYPE");
        model.addAttribute("cardTypes",dataDictionaries);
        //查询国家信息
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);
        return "u/register";
    }

    @RequestMapping("register")
    public String register(User user,
                           @RequestParam("idCardPicPosPathFile") MultipartFile idCardPicPosPathFile ,
                           @RequestParam("idCardPicNegPathFile") MultipartFile idCardPicNegPathFile ,
                           @RequestParam("bankPicPathFile") MultipartFile bankPicPathFile){

        //处理文件上传
        File dest1 = new File(fileConfig.getUploadRootPath(),idCardPicPosPathFile.getOriginalFilename());
        File dest2 = new File(fileConfig.getUploadRootPath(),idCardPicNegPathFile.getOriginalFilename());
        File dest3 = new File(fileConfig.getUploadRootPath(),bankPicPathFile.getOriginalFilename());
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
        userService.save(user);


        return "u/register";
    }


    @RequestMapping("toModifyPwd")
    public String toModifyPwd(){
        return "u/modifyPwd";
    }
    @RequestMapping("modifyPwd")
    @ResponseBody
    public ResponseCode modifyPwd(UserDto userDto,HttpSession session){
        ResponseCode code = new ResponseCode();
        User user = (User) session.getAttribute("loginUser");
        if(user == null){
            code.setCode(ResponseCode.FAIL);
            code.setMsg("请先登入");
            return code;
        }
        if(!user.getPassword().equals(userDto.getOldPwd())){
            code.setCode(ResponseCode.FAIL);
            code.setMsg("原密码输入错误");
            return code;
        }else{
            userDto.setLoginCode(user.getLoginCode());
            code = userService.modifyPwd(userDto);
        }

        return code;
    }
    @RequestMapping("modifyPwd2")
    @ResponseBody
    //啊啊啊啊啊实打实阿斯顿阿斯顿阿斯顿
    public ResponseCode modifyPwd2(UserDto userDto,HttpSession session){
        ResponseCode code = new ResponseCode();
        User user = (User) session.getAttribute("loginUser");
        if(user == null){
            code.setCode(ResponseCode.FAIL);
            code.setMsg("请先登入");
            return code;
        }
        if(!user.getPassword2().equals(userDto.getOldPwd2())){
            code.setCode(ResponseCode.FAIL);
            code.setMsg("原密码输入错误");
            return code;
        }else{
            userDto.setLoginCode(user.getLoginCode());
            code = userService.modifyPwd2(userDto);
        }

        return code;
    }

    @RequestMapping("toModify")
    public String toModify(HttpSession session,Model model){
        User u = (User) session.getAttribute("loginUser");

        if(u == null){
            return "u/login";
        }
        User user = userService.selectInfo(u.getLoginCode());
        model.addAttribute("user",user);

        List<DataDictionary> dictionaries = dictionaryService.findByTypeCode("CARD_TYPE");
        List<Country> countries = countryService.findAll();
        model.addAttribute("dictionaries",dictionaries);
        model.addAttribute("countries",countries);
        return "u/modify";
    }
    @RequestMapping("modify")
    public String modify(User user,
                         @RequestParam("idCardPicPosPathFile")MultipartFile idCardPicPosPathFile,
                         @RequestParam("idCardPicNegPathFile")MultipartFile idCardPicNegPathFile,
                         @RequestParam("bankPicPathFile")MultipartFile bankPicPathFile
                         ){
        //处理文件上传
        File dest1 = new File(fileConfig.getUploadRootPath(),idCardPicPosPathFile.getOriginalFilename());
        File dest2 = new File(fileConfig.getUploadRootPath(),idCardPicNegPathFile.getOriginalFilename());
        File dest3 = new File(fileConfig.getUploadRootPath(),bankPicPathFile.getOriginalFilename());
        try {
            idCardPicNegPathFile.transferTo(dest2);
            idCardPicPosPathFile.transferTo(dest1);
            bankPicPathFile.transferTo(dest3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setIdCardPicPosPath(idCardPicPosPathFile.getOriginalFilename());
        user.setIdCardPicNegPath(idCardPicNegPathFile.getOriginalFilename());
        user.setBankPicPath(bankPicPathFile.getOriginalFilename());
        userService.modify(user);
        return "main";
    }
    @RequestMapping("toList")
    public String toList(){
        return "u/list";
    }
    @RequestMapping("list")
    @ResponseBody
    public ResponseCode list(@RequestParam("limit")Integer pageSize,
                             @RequestParam("page")Integer pageNum,
                             @RequestParam(value = "loginCode",defaultValue = "")String loginCode){
        ResponseCode code = userService.queryAll(pageSize,pageNum,loginCode);
        return code;
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    public ResponseCode del(@PathVariable("id")Integer id){
        ResponseCode code = userService.del(id);
        return code;

    }

    @RequestMapping("delGroup")
    @ResponseBody
    public ResponseCode delGroup(@RequestBody IDDto idDto){
        ResponseCode code = userService.delGroup(idDto);
        return code;
    }


}
