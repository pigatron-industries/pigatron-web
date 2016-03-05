package com.pigatron.shop.web.admin;

import com.pigatron.shop.domain.repository.UserRepository;
import com.pigatron.shop.service.InitialConfigurationService;
import com.pigatron.shop.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

	private static final String VIEW_CONFIGURE = "pages/setup";
	private static final String VIEW_ADMIN = "pages/admin";
	private static final String VIEW_ADMINLOGIN = "pages/login";

	@Value("${url.admin}")
	private String adminUrl;

	@Value("${url.setup}")
	private String setupUrl;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private InitialConfigurationService initialConfigurationService;

	@ModelAttribute("configureForm")
	public InitialConfigurationForm getConfigureForm(){
		return new InitialConfigurationForm();
	}

	@ModelAttribute("adminUrl")
	public String getAdminUrl() {
		return adminUrl;
	}

	@ModelAttribute("setupUrl")
	public String getSetupUrl() {
		return setupUrl;
	}


	@RequestMapping(value = "/${url.admin}/login", method = RequestMethod.GET)
	public String adminLogin() {
		if(userRepository.count() == 0) {
			return VIEW_CONFIGURE;
		} else {
			return VIEW_ADMINLOGIN;
		}
	}

	@RequestMapping(value = "/${url.admin}/**", method = RequestMethod.GET)
	public String admin() {
		return VIEW_ADMIN;
	}

	@RequestMapping(value = "/${url.setup}", method = RequestMethod.POST)
	public String setup(@ModelAttribute InitialConfigurationForm configurationForm) {
		if(userRepository.count() == 0) {
			initialConfigurationService.configure(configurationForm);
			return "redirect:/" + adminUrl;
		} else {
			throw new ResourceNotFoundException();
		}
	}

}
