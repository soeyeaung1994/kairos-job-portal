package com.kairos.jobportal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 16/3/26
 * @Time: 11:18 am
 */

@Configuration
public class PathConfig {

    @Bean(name = "publicPaths")
    public List<String> publicPaths() {
        return List.of(
                "/api/auth/login/public",
                "/api/auth/register/public",
                "/api/companies/public",
                "/api/contacts/public",
                "/api/logging/public",
                "/api/csrf-token/public",
                "/api/swagger-ui.html",
                "/swagger-ui/**",
                "/api/v3/api-docs/**",
                "/swagger-resources/**",
                "/swagger-ui.html",
                "/webjars/**"
        );
    }

    @Bean(name = "securedPaths")
    public List<String> securedPaths() {
        return List.of(
                "/api/**"
        );
    }

}
