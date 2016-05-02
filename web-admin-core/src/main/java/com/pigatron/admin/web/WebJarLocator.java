package com.pigatron.admin.web;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;
import org.webjars.WebJarAssetLocator;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebJarLocator {

    @RequestMapping("/lib/{webjar}/**")
    public ResponseEntity locateWebjarAsset(@PathVariable String webjar, HttpServletRequest request) {
        try {
            WebJarAssetLocator webJarAssetLocator = new WebJarAssetLocator();
            String mvcPrefix = "/lib/" + webjar + "/"; // This prefix must match the mapping path
            String mvcPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
            String fullPath = webJarAssetLocator.getFullPath(webjar, mvcPath.substring(mvcPrefix.length()));
            return new ResponseEntity(new ClassPathResource(fullPath), HttpStatus.OK);
        } catch (Exception e) {
            try {
                return new ResponseEntity(new ClassPathResource("static"+request.getRequestURI()), HttpStatus.OK);
            } catch (Exception e2) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
    }

}
