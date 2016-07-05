package com.pigatron.pub.web;

import com.pigatron.web.admin.config.SubModules;
import com.pigatron.web.admin.config.WebResources;
import com.pigatron.web.core.settings.SettingsService;
import com.pigatron.web.core.settings.website.WebSiteSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {

    private static final String VIEW_INDEX = "pages/index";

    @Autowired
    private SettingsService settingsService;

    @Autowired
    private WebResources publicWebResources;

    @Autowired
    private SubModules publicSubmodules;

    @ModelAttribute("resources")
    public WebResources getResources() {
        return publicWebResources;
    }

    @ModelAttribute("submodules")
    public String getSubmodules() {
        //TODO pass back list and create js array in template
        String s = publicSubmodules.getSubmodules().toString();
        s = s.substring(1, s.length()-1);
        s = s.replaceAll("\\s","");
        return s;
    }

    @ModelAttribute("settings")
    public WebSiteSettings webSiteSettings() {
        return (WebSiteSettings)settingsService.findOne(WebSiteSettings.ID);
    }

    @RequestMapping(value = {"/**"})
    public String index() {
        return VIEW_INDEX;
    }

}
