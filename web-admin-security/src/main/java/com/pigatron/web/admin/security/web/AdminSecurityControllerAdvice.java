package com.pigatron.web.admin.security.web;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice(basePackages = {"com.pigatron.web.admin"})
public class AdminSecurityControllerAdvice {

    @ModelAttribute("metadata")
    public Map<String, String> getMetadata(HttpServletRequest request) {
        Map<String, String> metadata = new HashMap<>();
        CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
        if(token != null) {
            metadata.put("_csrf", token.getToken());
            metadata.put("_csrf_header", token.getHeaderName());
        }
        return metadata;
    }

}
