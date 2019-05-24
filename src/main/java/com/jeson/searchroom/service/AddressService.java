package com.jeson.searchroom.service;

import com.jeson.searchroom.entity.Subway;
import com.jeson.searchroom.entity.SubwayStation;
import com.jeson.searchroom.web.dto.SupportAddressDTO;

/**
 * ${DESCRIPTION}
 *
 * @author jason
 * @create 2019-05-23 21:15
 **/
public interface AddressService {

    /**
     * 获取所有的城市
     * */
    ServiceMultiResult<SupportAddressDTO>findAllCities();

    /**
     * 根据城市获取区/县
     */
    ServiceMultiResult<SupportAddressDTO>findAllRegionsByCity(String city);

    /**
     * 根据城市获取地铁线路线
     * */
    ServiceMultiResult<Subway>findAllSubwayByCity(String city);

    /**
     * 根据地铁路线获取地铁站台信息
     * */
    ServiceMultiResult<SubwayStation> finAllSubwayStationByLine(Long subwayId);
}
