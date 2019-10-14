package com.qiudaozhang.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * au_role
 * @author 
 */
@Getter
@Setter
public class Role implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 角色编码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建日期
     */
    private LocalDate createDate;

    /**
     * 是否启用（0、未启用1、启用）
     */
    private Integer isStart;

    /**
     * 创建者
     */
    private String createdBy;

    private static final long serialVersionUID = 1L;


}