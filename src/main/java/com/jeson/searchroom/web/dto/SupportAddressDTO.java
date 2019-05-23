package com.jeson.searchroom.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ${DESCRIPTION}
 *
 * @author jason
 * @create 2019-05-23 21:32
 **/
public class SupportAddressDTO {
    private Long id;

    @JsonProperty(value = "belong_to")
    private String belongTo;

    @JsonProperty(value = "cn_name")
    private String cnName;

    @JsonProperty(value = "en_name")
    private String enName;

    private String level;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBelongTo() {
        return belongTo;
    }

    public void setBelongTo(String belongTo) {
        this.belongTo = belongTo;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
