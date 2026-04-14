package com.kairos.jobportal.company.service;

import com.kairos.jobportal.dto.CompanyDto;
import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 27/2/26
 * @Time: 5:23 pm
 */
public interface ICompanyService {

    List<CompanyDto> getAllCompanies();

    List<CompanyDto> getAllCompaniesForAdmin();

    void deleteCompanyById(Long id);

    boolean updateCompanyDetails(Long id, CompanyDto companyDto);

    boolean createCompany(CompanyDto companyDto);

}
