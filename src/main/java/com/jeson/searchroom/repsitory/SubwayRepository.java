package com.jeson.searchroom.repsitory;

import com.jeson.searchroom.entity.Subway;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-05-24 9:56
 **/
public interface SubwayRepository extends CrudRepository<Subway,Long> {
     List<Subway> getAllByCityEnName(String city);
}
