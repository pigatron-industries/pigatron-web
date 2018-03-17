package com.pigatron.web.admin.security.config;

import com.pigatron.web.security.repository.UserTokenRepository;
import com.pigatron.web.security.service.SecUserDetailsService;
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
@Order(2)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${url.admin}")
    private String adminUrl;

    @Value("${user.rememberMeValidityDays}")
    private int rememberMeValidityDays;

    @Autowired
    private SecUserDetailsService secUserDetailsService;

    @Autowired
    private UserTokenRepository userTokenRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .antMatcher("/" + adminUrl + "/**")
//                .authorizeRequests()
//                .anyRequest().hasAuthority(SecUserDetailsService.ROLE_ADMIN)
//                .and()
//            .formLogin()
//                .loginPage("/" + adminUrl + "/login")
//                .defaultSuccessUrl("/" + adminUrl)
//                .permitAll()
//                .and()
//            .rememberMe()
//                .rememberMeParameter("remember-me")
//                .tokenRepository(userTokenRepository)
//                .tokenValiditySeconds(rememberMeValidityDays*24*60*60);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(secUserDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
