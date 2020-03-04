package com.jeson.searchroom.entity;

import javax.persistence.*;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-05-24 9:49
 *
 * 地铁线路
 **/
@Entity
@Table(name = "subway")
public class Subway {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "city_en_name")
    private String cityEnName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityEnName() {
        return cityEnName;
    }

    public void setCityEnName(String cityEnName) {
        this.cityEnName = cityEnName;
    }
}