package com.qiudaozhang.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * data_dictionary
 * @author 
 */
@Getter
@Setter
public class DataDictionary implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 类型编码
     */
    private String typeCode;

    /**
     * 类型名称
     */
    private String typeName;

    /**
     * 类型值ID
     */
    private Integer valueId;

    /**
     * 类型值Name
     */
    private String valueName;

    private static final long serialVersionUID = 1L;

}