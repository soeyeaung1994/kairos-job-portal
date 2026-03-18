package com.kairos.jobportal.company.service.impl;

import com.kairos.jobportal.company.service.ICompanyService;
import com.kairos.jobportal.dto.CompanyDto;
import com.kairos.jobportal.dto.JobDto;
import com.kairos.jobportal.entity.Company;
import com.kairos.jobportal.entity.Job;
import com.kairos.jobportal.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Soe Ye Aung
 * @Date: 27/2/26
 * @Time: 5:19 pm
 */

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyDto> getAllCompanies() {
        List<Company> companyList = companyRepository.findAll();
        return companyList.stream().map(this::transformCompanyEntityToDto).collect(Collectors.toList());
    }

    private CompanyDto transformCompanyEntityToDto(Company company){

        List<JobDto> jobDtos = company.getJobs().stream()
                .map(this::transformJobEntityToDto).collect(Collectors.toList());

        return new CompanyDto(company.getId(), company.getName(), company.getLogo(),
                company.getIndustry(), company.getSize(), company.getRating(),
                company.getLocations(), company.getFounded(), company.getDescription(),
                company.getEmployees(), company.getWebsite(), company.getCreatedAt(), jobDtos);
    }

    private JobDto transformJobEntityToDto(Job job){
        return new JobDto(
                job.getId(),
                job.getTitle(),
                job.getCompany().getId(),
                job.getCompany().getName(),
                job.getCompany().getLogo(),
                job.getLocation(),
                job.getWorkType(),
                job.getJobType(),
                job.getCategory(),
                job.getExperienceLevel(),
                job.getSalaryMin(),
                job.getSalaryMax(),
                job.getSalaryCurrency(),
                job.getSalaryPeriod(),
                job.getDescription(),
                job.getRequirements(),
                job.getBenefits(),
                job.getPostedDate(),
                job.getApplicationDeadline(),
                job.getApplicationsCount(),
                job.getFeatured(),
                job.getUrgent(),
                job.getRemote(),
                job.getStatus()
        );
    }
}
