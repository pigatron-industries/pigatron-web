package com.pigatron.admin.web;

import com.pigatron.admin.config.wro.SubModules;
import com.pigatron.server.security.repository.UserRepository;
import com.pigatron.admin.menu.MenuItem;
import com.pigatron.server.security.SecUserDetailsService;
import com.pigatron.server.web.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminController {

	private static final String VIEW_ADMIN = "pages/admin";

	@Value("${url.admin}")
	private String adminUrl;

	@Autowired
	private MenuItem adminMenu;

	@Autowired
	private SubModules submodules;

	@ModelAttribute("adminUrl")
	public String getAdminUrl() {
		return adminUrl;
	}

	@ModelAttribute("adminMenu")
	public MenuItem getAdminMenu() {
		return adminMenu;
	}

	@ModelAttribute("submodules")
	public String getSubmodules() {
		String s = submodules.getSubmodules().toString();
		s = s.substring(1, s.length()-1);
		s = s.replaceAll("\\s","");
		return s;
	}

	@ModelAttribute("metadata")
	public Map<String, String> getMetadata() {
		Map<String, String> metadata = new HashMap<>();
		return metadata;
	}

	@RequestMapping(value = "/${url.admin}/**", method = RequestMethod.GET)
	public String admin() {
		return VIEW_ADMIN;
	}

}
