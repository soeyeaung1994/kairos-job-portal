package com.kairos.jobportal.dto;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 27/2/26
 * @Time: 6:03 pm
 *
*/

public record CompanyDto(Long id, String name, String logo, String industry, String size, BigDecimal rating, String locations,
                         Integer founded, String description, Integer employees, String website,
                         Instant createdAt, List<JobDto> jobs) {
}
