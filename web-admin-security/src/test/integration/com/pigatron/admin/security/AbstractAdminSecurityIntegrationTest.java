package com.pigatron.admin.security;


import com.pigatron.admin.AbstractAdminCoreIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractAdminSecurityIntegrationTest extends AbstractAdminCoreIntegrationTest {

    @Autowired
    private SecUserDetailsService userDetailsService;

    @Override
    protected void dbSetup() {
        super.dbSetup();
        userDetailsService.createAdminUser("admin", "password");
    }
}
