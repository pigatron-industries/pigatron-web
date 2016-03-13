package com.pigatron.admin.config;

import com.pigatron.admin.service.security.SecUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${url.admin}")
    private String adminUrl;

    @Autowired
    private SecUserDetailsService secUserDetailsService;

    @Autowired
    private ApiAuthenticationEntryPoint apiAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/" + adminUrl + "/api/**")
            .authorizeRequests()
            .anyRequest().hasAuthority(SecUserDetailsService.ROLE_ADMIN)
        .and()
            .exceptionHandling().authenticationEntryPoint(apiAuthenticationEntryPoint);
        ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(secUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
