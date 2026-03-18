package com.kairos.jobportal.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

/**
 * @Author: Soe Ye Aung
 * @Date: 17/3/26
 * @Time: 12:06 pm
 */

@Getter
@Setter
@ToString
public class UserDto {

    private Long userId;
    private String name;
    private String email;
    private String mobileNumber;
    private String role;
    private Long companyId;
    private String companyName;
    private Instant createdAt;

}
