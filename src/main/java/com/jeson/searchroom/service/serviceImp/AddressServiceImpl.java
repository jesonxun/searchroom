package com.jeson.searchroom.service.serviceImp;

import com.jeson.searchroom.entity.Subway;
import com.jeson.searchroom.entity.SubwayStation;
import com.jeson.searchroom.entity.SupportAddress;
import com.jeson.searchroom.repsitory.SubwayRepository;
import com.jeson.searchroom.repsitory.SubwayStationRepository;
import com.jeson.searchroom.repsitory.SupportAddressRepository;
import com.jeson.searchroom.service.AddressService;
import com.jeson.searchroom.service.ServiceMultiResult;
import com.jeson.searchroom.web.dto.SupportAddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jason
 * @create 2019-05-23 21:15
 **/
@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    SupportAddressRepository supportAddressRepository;

    @Autowired
    SubwayRepository subwayRepository;

    @Autowired
    SubwayStationRepository subwayStationRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ServiceMultiResult<SupportAddressDTO> findAllCities() {
        List<SupportAddress> cities =
                supportAddressRepository.findAllByLevel(
                        SupportAddress.Level.of("city").getValue()
                );
        List<SupportAddressDTO> supportAddresses = new ArrayList<>();
        cities.forEach(city->{
            SupportAddressDTO supportAddressDTO =
                    modelMapper.map(city, SupportAddressDTO.class);
            supportAddresses.add(supportAddressDTO);
        });
        return new ServiceMultiResult<>(supportAddresses.size(),supportAddresses);
    }

    @Override
    public ServiceMultiResult<SupportAddressDTO> findAllRegionsByCity(String city) {
        if (StringUtils.isEmpty(city)){
            return new ServiceMultiResult<>(0,null);
        }
        List<SupportAddress> region =
                supportAddressRepository.findAllByLevelAndBelongTo(SupportAddress.Level.of("region").getValue(), city);
        List<SupportAddressDTO>supportAddressDTOS = new ArrayList<>();
        region.forEach(item->{
            SupportAddressDTO addressDTO =
                    modelMapper.map(item, SupportAddressDTO.class);
            supportAddressDTOS.add(addressDTO);
        });
        return new ServiceMultiResult<>(supportAddressDTOS.size(),supportAddressDTOS);
    }

    @Override
    public ServiceMultiResult<Subway> findAllSubwayByCity(String city) {
        List<Subway> allByCityEnName = subwayRepository.getAllByCityEnName(city);
        if (allByCityEnName.size() == 0){
            return new ServiceMultiResult<>(0,null);
        }
        return new ServiceMultiResult<>(allByCityEnName.size(),allByCityEnName);
    }

    @Override
    public ServiceMultiResult<SubwayStation> finAllSubwayStationByLine(Long subwayId) {
        List<SubwayStation> allBySubwayId = subwayStationRepository.findAllBySubwayId(subwayId);
        if (allBySubwayId.size() == 0){
            return new ServiceMultiResult<>(0,null);
        }
        return new ServiceMultiResult<>(allBySubwayId.size(),allBySubwayId);
    }
}
