package com.kairos.jobportal.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Soe Ye Aung
 * @Date: 18/3/26
 * @Time: 5:24 pm
 */

@RestController
@RequestMapping("/csrf-token")
public class CsrfController {

    // Client asks backend server to generate CSRF token -> After generation, send cookie, Response Body back to client
    @GetMapping(path = "/public", version = "1.0")
    public CsrfToken csrfToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute(CsrfToken.class.getName());
    }

}
