package com.kairos.jobportal.company.controller;

import com.kairos.jobportal.aspects.LogAspect;
import com.kairos.jobportal.company.service.ICompanyService;
import com.kairos.jobportal.dto.CompanyDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 27/2/26
 * @Time: 11:48 am
 */

@RestController
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final ICompanyService companyService;

//    @LogAspect
    @GetMapping(path = "/public", version = "1.0")
    public ResponseEntity<List<CompanyDto>> getAllCompanies(){
        List<CompanyDto> allCompanies = companyService.getAllCompanies();
        return ResponseEntity.ok(allCompanies);
    }
}
