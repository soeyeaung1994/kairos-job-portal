package com.kairos.jobportal.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @Author: Soe Ye Aung
 * @Date: 9/3/26
 * @Time: 3:17 pm
 */

@Component("auditorAwareImpl")
public class AuditorAwareImpl implements AuditorAware {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("Anonymous User");
    }
}
