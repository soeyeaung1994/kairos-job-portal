package com.kairos.jobportal.dto;

import java.time.Instant;

/**
 * @Author: Soe Ye Aung
 * @Date: 8/4/26
 * @Time: 11:02 am
 */

public record ContactResponseDto(
        Long id, String name, String email,
        String userType, String subject, String message,
        String status, Instant createdAt
) {
}
