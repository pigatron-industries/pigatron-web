package com.pigatron.pub.web;

import com.pigatron.admin.config.WebResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {

    private static final String VIEW_INDEX = "pages/index";

    @Autowired
    private WebResources publicWebResources;

    @ModelAttribute("resources")
    public WebResources getResources() {
        return publicWebResources;
    }

    @RequestMapping(value = {"/**"})
    public String index() {
        return VIEW_INDEX;
    }

}
