package com.kairos.jobportal.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @Author: Soe Ye Aung
 * @Date: 7/3/26
 * @Time: 5:01 pm
 */
public record ErrorResponseDto(String apiPath, HttpStatus errorCode, String errorMessage,
                               LocalDateTime errorTime) {
}
