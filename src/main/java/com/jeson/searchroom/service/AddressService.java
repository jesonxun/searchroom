package com.jeson.searchroom.service;

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
     * 获取区/县
     */
    ServiceMultiResult<SupportAddressDTO>findAllRegionsByCity(String city);
}
