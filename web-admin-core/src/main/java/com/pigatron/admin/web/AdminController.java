package com.pigatron.admin.web;

import com.pigatron.admin.config.wro.SubModules;
import com.pigatron.admin.menu.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AdminController {

	private static final String VIEW_ADMIN = "admin/pages/admin";

	@Value("${url.admin}")
	private String adminUrl;

	@Value("${pigatron.revision}")
	private String revision;

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
	public Map<String, String> getMetadata(HttpServletRequest request) {
		Map<String, String> metadata = new HashMap<>();
		return metadata;
	}

	@ModelAttribute("revision")
	public String getRevision() {
		return revision;
	}

	@RequestMapping(value = "/${url.admin}/**", method = RequestMethod.GET)
	public String admin() {
		return VIEW_ADMIN;
	}

}
