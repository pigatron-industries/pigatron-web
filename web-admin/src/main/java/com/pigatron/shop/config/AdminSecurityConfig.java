package com.pigatron.shop.config;

import com.pigatron.shop.service.SecUserDetailsService;
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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@Order(2)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${url.admin}")
    private String adminUrl;

    @Autowired
    private SecUserDetailsService secUserDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/" + adminUrl + "/**")
                .authorizeRequests()
                .anyRequest().hasAuthority(SecUserDetailsService.ROLE_ADMIN)
                .and()
            .formLogin()
                .loginPage("/" + adminUrl + "/login")
                .defaultSuccessUrl("/" + adminUrl)
                .permitAll()
                .and()
            .rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(secUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
