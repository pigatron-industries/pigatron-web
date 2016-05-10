package com.pigatron.pub.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PublicController {

    private static final String VIEW_INDEX = "pages/index";

    @RequestMapping(value = {"/"})
    public String admin() {
        return VIEW_INDEX;
    }

}
