package com.pigatron.admin.security.config;

import com.pigatron.admin.security.SecUserDetailsService;
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

    @Value("${admin.api.basicAuth}")
    private boolean basicAuth;

    @Autowired
    private SecUserDetailsService secUserDetailsService;

    @Autowired
    private ApiAuthenticationEntryPoint apiAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        HttpSecurity and = http
                .antMatcher("/" + adminUrl + "/api/**")
                .authorizeRequests()
                .anyRequest().hasAuthority(SecUserDetailsService.ROLE_ADMIN)
                .and();
        if(basicAuth) {
            and.httpBasic().and().csrf().disable();
        } else {
            and.exceptionHandling().authenticationEntryPoint(apiAuthenticationEntryPoint);
        }
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(secUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
