package com.kairos.jobportal.repository;

import com.kairos.jobportal.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 17/3/26
 * @Time: 5:52 pm
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findRoleByName(String name);

}
