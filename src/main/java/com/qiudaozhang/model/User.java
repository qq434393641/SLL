package com.qiudaozhang.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * au_user
 * @author 
 */
@Getter
@Setter
public class User implements Serializable {

    private User recommender;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 登录账号
     */
    private String loginCode;

    /**
     * 登录密码（初始密码为证件号码后六位）
     */
    private String password;

    /**
     * 二级密码（初始密码为证件号码后六位）
     */
    private String password2;

    /**
     * 用户真实姓名
     */
    private String userName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 证件类型id
     */
    private String cardType;

    /**
     * 证件类型名称
     */
    private String cardTypeName;

    /**
     * 证件号码
     */
    private String idCard;

    /**
     * 收货国家
     */
    private String country;

    /**
     * 手机
     */
    private String mobile;

    /**
     * email
     */
    private String email;

    /**
     * 收获地址
     */
    private String userAddress;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 推荐人id（默认为当前登录用户id）
     */
    private Long referId;

    /**
     * 推荐人编码（默认为当前登录用户loginCode）
     */
    private String referCode;

    /**
     * 所属角色ID
     */
    private Long roleId;

    /**
     * 所属角色名称
     */
    private String roleName;

    /**
     * 用户类型id
     */
    private String userType;

    /**
     * 用户类型名称
     */
    private String userTypeName;

    /**
     * 是否启用（1、启用2、未启用）
     */
    private Integer isStart;

    /**
     * 最新更新时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 开户卡号
     */
    private String bankAccount;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 开户人
     */
    private String accountHolder;

    /**
     * 身份证照片反面图路径
     */
    private String idCardPicNegPath;

    /**
     * 身份证照片正面图路径
     */
    private String idCardPicPosPath;

    /**
     * 银行卡照片存放路径
     */
    private String bankPicPath;

    private static final long serialVersionUID = 1L;
    public String getCreateTimeStr(){
        return this.createTime.toLocalDate() + " " + (this.createTime.toLocalTime().toString().equals("00:00") ? "00:00:00":this.createTime.toLocalTime());
    }


    public String getLastUpdateTimeStr(){
        if(this.lastUpdateTime == null)
            return "";
        return this.lastUpdateTime.toLocalDate() + " " + (this.lastUpdateTime.toLocalTime().toString().equals("00:00") ? "00:00:00":this.lastUpdateTime.toLocalTime());
    }

}