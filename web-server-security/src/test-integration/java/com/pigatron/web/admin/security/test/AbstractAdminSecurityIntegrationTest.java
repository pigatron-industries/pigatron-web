package com.pigatron.web.admin.security.test;


import com.pigatron.web.core.AbstractAdminCoreIntegrationTest;
import com.pigatron.web.security.service.SecUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractAdminSecurityIntegrationTest extends AbstractAdminCoreIntegrationTest {

    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "password";

    @Autowired
    private SecUserDetailsService userDetailsService;

    @Override
    protected void dbSetup() {
        super.dbSetup();
        userDetailsService.createAdminUser(ADMIN_USERNAME, ADMIN_PASSWORD);
    }
}
