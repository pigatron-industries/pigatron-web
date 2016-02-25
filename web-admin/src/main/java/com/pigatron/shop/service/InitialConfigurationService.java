package com.pigatron.shop.service;

import com.pigatron.shop.web.admin.InitialConfigurationForm;
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
