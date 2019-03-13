package com.jeson.searchroom.repsitory;

import com.jeson.searchroom.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-11 15:23
 **/
public interface UserRepsitory extends CrudRepository <User,Long> {

    User findUserByName(String UserName);

}
