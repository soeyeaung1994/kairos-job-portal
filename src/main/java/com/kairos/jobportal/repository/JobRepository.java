package com.kairos.jobportal.repository;

import com.kairos.jobportal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Soe Ye Aung
 * @Date: 15/6/26
 * @Time: 6:03 pm
 */

public interface JobRepository extends JpaRepository<Job, Long> {
}
