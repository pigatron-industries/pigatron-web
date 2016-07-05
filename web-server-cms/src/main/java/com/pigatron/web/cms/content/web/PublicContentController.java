package com.pigatron.web.cms.content.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.pigatron.web.cms.content.entity.Content;
import com.pigatron.web.cms.content.service.ContentService;
import com.pigatron.web.core.api.View;
import com.pigatron.web.core.exception.InvalidParameterException;
import com.pigatron.web.core.exception.ResourceNotFoundException;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${url.public}/api/cms/content", produces = MediaType.APPLICATION_JSON_VALUE)
public class PublicContentController  {

    private ContentService contentService;

    @Autowired
    public PublicContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    @RequestMapping(value = "/page", method = RequestMethod.GET, params = {"urlKey"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get page by URL Key")
    @JsonView(View.Public.class)
    public Content getPageByUrlKey(@RequestParam("urlKey") String urlKey) {
        if(urlKey == null) {
            throw new InvalidParameterException("urlKey cannot be null");
        }
        return contentService.getPublishedPageByUrlKey(urlKey).orElseThrow(ResourceNotFoundException::new);
    }

}
