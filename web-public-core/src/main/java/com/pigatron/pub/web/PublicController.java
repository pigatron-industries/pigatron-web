package com.pigatron.pub.web;

import com.pigatron.admin.config.WebResources;
import com.pigatron.admin.settings.SettingsService;
import com.pigatron.admin.settings.website.WebSiteSettings;
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

    @ModelAttribute("resources")
    public WebResources getResources() {
        return publicWebResources;
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
