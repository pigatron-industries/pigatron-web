package com.pigatron.admin.web;

import com.pigatron.admin.config.wro.SubModules;
import com.pigatron.shop.security.repository.UserRepository;
import com.pigatron.admin.menu.MenuItem;
import com.pigatron.shop.security.SecUserDetailsService;
import com.pigatron.server.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.webjars.WebJarAssetLocator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
	SecUserDetailsService secUserDetailsService;

	@Autowired
	private MenuItem adminMenu;

	@Autowired
	private SubModules submodules;

	@ModelAttribute("adminUrl")
	public String getAdminUrl() {
		return adminUrl;
	}

	@ModelAttribute("setupUrl")
	public String getSetupUrl() {
		return setupUrl;
	}

	@ModelAttribute("adminMenu")
	public MenuItem getAdminMenu() {
		return adminMenu;
	}

	@ModelAttribute("submodules")
	public String getSubmodules() {
		String s = submodules.getSubmodules().toString();
		return s.substring(1, s.length()-1);
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
	public String setup(@ModelAttribute CreateUserForm configurationForm) {
		if(userRepository.count() == 0) {
			secUserDetailsService.createAdminUser(configurationForm.getAdminUsername(), configurationForm.getAdminPassword());
			return "redirect:/" + adminUrl;
		} else {
			throw new ResourceNotFoundException();
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public @ResponseBody void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		CookieClearingLogoutHandler cookieClearingLogoutHandler = new CookieClearingLogoutHandler(AbstractRememberMeServices.SPRING_SECURITY_REMEMBER_ME_COOKIE_KEY);
		SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
		cookieClearingLogoutHandler.logout(request, response, null);
		securityContextLogoutHandler.logout(request, response, null);
	}

}
