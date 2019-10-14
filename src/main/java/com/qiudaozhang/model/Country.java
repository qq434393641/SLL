package com.qiudaozhang.model;

import java.io.Serializable;

/**
 * country
 * @author 
 */
public class Country implements Serializable {
    /**
     * 自增id
     */
    private Integer id;

    /**
     * 对应七大陆continent表的id
     */
    private Integer continentId;

    /**
     * 英文常用标准名称，主要用于显示
     */
    private String name;

    /**
     * 对应于英文标准名称的小写，主要用于搜索比较
     */
    private String lowerName;

    /**
     * 英文缩写名称，全大写
     */
    private String countryCode;

    /**
     * 英文标准名称全称
     */
    private String fullName;

    /**
     * 中文常用标准名称，通常简称
     */
    private String cname;

    /**
     * 中文全称名称，非缩写
     */
    private String fullCname;

    /**
     * 七大洲
     */
    private String continent;

    /**
     * 备注字段，保留
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContinentId() {
        return continentId;
    }

    public void setContinentId(Integer continentId) {
        this.continentId = continentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLowerName() {
        return lowerName;
    }

    public void setLowerName(String lowerName) {
        this.lowerName = lowerName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getFullCname() {
        return fullCname;
    }

    public void setFullCname(String fullCname) {
        this.fullCname = fullCname;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Country other = (Country) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getContinentId() == null ? other.getContinentId() == null : this.getContinentId().equals(other.getContinentId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getLowerName() == null ? other.getLowerName() == null : this.getLowerName().equals(other.getLowerName()))
            && (this.getCountryCode() == null ? other.getCountryCode() == null : this.getCountryCode().equals(other.getCountryCode()))
            && (this.getFullName() == null ? other.getFullName() == null : this.getFullName().equals(other.getFullName()))
            && (this.getCname() == null ? other.getCname() == null : this.getCname().equals(other.getCname()))
            && (this.getFullCname() == null ? other.getFullCname() == null : this.getFullCname().equals(other.getFullCname()))
            && (this.getContinent() == null ? other.getContinent() == null : this.getContinent().equals(other.getContinent()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getContinentId() == null) ? 0 : getContinentId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getLowerName() == null) ? 0 : getLowerName().hashCode());
        result = prime * result + ((getCountryCode() == null) ? 0 : getCountryCode().hashCode());
        result = prime * result + ((getFullName() == null) ? 0 : getFullName().hashCode());
        result = prime * result + ((getCname() == null) ? 0 : getCname().hashCode());
        result = prime * result + ((getFullCname() == null) ? 0 : getFullCname().hashCode());
        result = prime * result + ((getContinent() == null) ? 0 : getContinent().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", continentId=").append(continentId);
        sb.append(", name=").append(name);
        sb.append(", lowerName=").append(lowerName);
        sb.append(", countryCode=").append(countryCode);
        sb.append(", fullName=").append(fullName);
        sb.append(", cname=").append(cname);
        sb.append(", fullCname=").append(fullCname);
        sb.append(", continent=").append(continent);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}