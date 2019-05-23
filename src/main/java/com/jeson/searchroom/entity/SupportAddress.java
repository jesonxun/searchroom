package com.jeson.searchroom.entity;

import com.jeson.searchroom.exception.BaseException;

import javax.persistence.*;

/**
 * ${DESCRIPTION}
 *
 * @author jason
 * @create 2019-05-22 23:57
 *
 * 新政单位
 **/
@Entity
@Table(name = "support_address")
public class SupportAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 一级行政单位
     * */
    @Column(name = "belong_to")
    private String belongTo;
    /**
     * 行政党委英文名
     * */
    @Column(name = "en_name")
    private String enName;
    /**
     * 行政单位中文名
     * */
    @Column(name = "cn_name")
    private String cnName;

    /**
     * 行政级别 市-city 地区-region
     */
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

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public enum Level{
        CITY("city"),
        REGION("region");

        private String value;

        Level(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Level of(String value){
            for (Level level : Level.values()) {
                if (level.value.equals(value)){
                    return level;
                }

            }
            throw new BaseException("level not exit");
        }

    }


}
