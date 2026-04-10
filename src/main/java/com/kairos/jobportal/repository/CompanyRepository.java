package com.kairos.jobportal.repository;

import com.kairos.jobportal.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 27/2/26
 * @Time: 3:04 pm
 */

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("SELECT DISTINCT c FROM Company c JOIN FETCH c.jobs j where j.status = :status")
    List<Company> findAllWithJobsByStatus(@Param("status") String status);

    List<Company> fetchCompaniesWithJobsByStatus(@Param("status") String status);

    @Query(value = "SELECT DISTINCT c.* FROM companies c JOIN jobs j ON c.id = j.company_id where j.status = ?",
            nativeQuery = true)
    List<Company> findAllWithJobsByStatusNative(String status);

    List<Company> fetchCompaniesWithJobsByStatusNative(@Param("status") String status);

}
