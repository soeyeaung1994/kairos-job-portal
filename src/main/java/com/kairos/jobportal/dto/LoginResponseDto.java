package com.kairos.jobportal.dto;

/**
 * @Author: Soe Ye Aung
 * @Date: 17/3/26
 * @Time: 12:06 pm
 */

public record LoginResponseDto(String message, UserDto user, String jwtToken) {
}
