package com.kairos.jobportal.security;

import com.kairos.jobportal.entity.JobPortalUser;
import com.kairos.jobportal.repository.JobPortalUserRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * @Author: Soe Ye Aung
 * @Date: 18/3/26
 * @Time: 11:54 am
 */

@Configuration
@RequiredArgsConstructor
public class JobPortalUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    private final JobPortalUserRepository jobPortalUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public @Nullable Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        JobPortalUser jobPortalUser = jobPortalUserRepository.findJobPortalUserByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User details not found for the user: " + username));

        List<SimpleGrantedAuthority> authorities = List.of(
                new SimpleGrantedAuthority(jobPortalUser.getRole().getName()));
        if (passwordEncoder.matches(pwd, jobPortalUser.getPasswordHash())) {
            return new UsernamePasswordAuthenticationToken(jobPortalUser, null, authorities);
        } else {
            throw new BadCredentialsException("Invalid password!");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
