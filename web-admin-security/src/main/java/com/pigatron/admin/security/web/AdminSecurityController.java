package com.pigatron.admin.security.web;

import com.pigatron.admin.web.CreateUserForm;
import com.pigatron.admin.security.SecUserDetailsService;
import com.pigatron.admin.security.repository.UserRepository;
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

@Controller
public class AdminSecurityController {

    private static final String VIEW_CONFIGURE = "pages/setup";
    private static final String VIEW_ADMINLOGIN = "pages/login";

    @Value("${url.admin}")
    private String adminUrl;

    @Value("${url.setup}")
    private String setupUrl;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    SecUserDetailsService secUserDetailsService;

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
