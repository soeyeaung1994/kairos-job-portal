package com.kairos.jobportal.repository;

import com.kairos.jobportal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Soe Ye Aung
 * @Date: 27/2/26
 * @Time: 3:04 pm
 */

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}
