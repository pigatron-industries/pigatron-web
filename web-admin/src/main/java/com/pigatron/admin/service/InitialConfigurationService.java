package com.pigatron.admin.service;

import com.pigatron.admin.service.security.SecUserDetailsService;
import com.pigatron.admin.web.InitialConfigurationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InitialConfigurationService {

	@Autowired
	SecUserDetailsService secUserDetailsService;

	public void configure(InitialConfigurationForm initialConfigurationForm) {
		secUserDetailsService.createAdminUser(initialConfigurationForm.getAdminUsername(), initialConfigurationForm.getAdminPassword());
	}

}
