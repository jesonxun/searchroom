package com.jeson.searchroom.web.controller.house;

import com.jeson.searchroom.base.ApiResponse;
import com.jeson.searchroom.entity.Subway;
import com.jeson.searchroom.entity.SubwayStation;
import com.jeson.searchroom.service.AddressService;
import com.jeson.searchroom.service.ServiceMultiResult;
import com.jeson.searchroom.web.dto.SupportAddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${DESCRIPTION}
 *
 * @author jason
 * @create 2019-05-22 23:56
 **/
@Controller
public class HouseController {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/address/support/cities", method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse supportAddress(){
        ServiceMultiResult<SupportAddressDTO> allCities = addressService.findAllCities();
        if (allCities.getTotal() == 0){
            return ApiResponse.ofSuccess(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(allCities);
    }

    @RequestMapping(value = "/address/support/regions",method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse findRegionsByCity(@RequestParam String city_name){
        ServiceMultiResult<SupportAddressDTO> allRegionsByCity =
                addressService.findAllRegionsByCity(city_name);
        if (allRegionsByCity.getTotal() == 0){
            return ApiResponse.ofSuccess(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(allRegionsByCity);
    }

    @RequestMapping(value = "/address/support/subway/line" ,method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse findAllSubwayByCity(@RequestParam String city_name){
        ServiceMultiResult<Subway> allSubwayByCity = addressService.findAllSubwayByCity(city_name);
        if (allSubwayByCity.getTotal() == 0){
            return ApiResponse.ofSuccess(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(allSubwayByCity);
    }

    @RequestMapping(value = "/address/support/subway/station",method = RequestMethod.GET)
    @ResponseBody
    public ApiResponse findAllSubwayStationByLine(@RequestParam Long subway_id){
        ServiceMultiResult<SubwayStation> subwayStation =
                addressService.finAllSubwayStationByLine(subway_id);
        if (subwayStation.getTotal() == 0){
            return ApiResponse.ofSuccess(ApiResponse.Status.NOT_FOUND);
        }
        return ApiResponse.ofSuccess(subwayStation);
    }


}
