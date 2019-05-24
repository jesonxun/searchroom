package com.jeson.searchroom.repsitory;

import com.jeson.searchroom.entity.SubwayStation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-05-24 10:26
 **/
public interface SubwayStationRepository extends CrudRepository<SubwayStation,Long> {

    List<SubwayStation> findAllBySubwayId(Long subwayId);

}
