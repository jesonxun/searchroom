package com.jeson.searchroom.repsitory;

import com.jeson.searchroom.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-13 14:57
 **/
public interface RoleRepsitory extends CrudRepository<Role,Long> {
    List<Role> findRoleByUserId(Long userId);
}
