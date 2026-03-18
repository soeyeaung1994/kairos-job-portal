package com.kairos.jobportal.repository;

import com.kairos.jobportal.entity.JobPortalUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 17/3/26
 * @Time: 5:52 pm
 */

public interface JobPortalUserRepository extends JpaRepository<JobPortalUser, Long> {

    Optional<JobPortalUser> readUserByEmailOrMobileNumber(String email, String mobileNumber);

    Optional<JobPortalUser> findJobPortalUserByEmail(String email);

}
