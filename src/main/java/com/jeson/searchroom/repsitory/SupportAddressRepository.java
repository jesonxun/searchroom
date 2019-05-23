package com.jeson.searchroom.repsitory;

import com.jeson.searchroom.entity.SupportAddress;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jason
 * @create 2019-05-23 0:23
 **/
public interface SupportAddressRepository extends CrudRepository<SupportAddress,Long> {

    List<SupportAddress> findAllByLevel(String level);

    List<SupportAddress> findAllByLevelAndBelongTo(String level,String belongTo);

}
