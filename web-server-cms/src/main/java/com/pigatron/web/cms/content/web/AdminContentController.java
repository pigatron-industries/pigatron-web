package com.pigatron.web.cms.content.web;

import com.pigatron.web.cms.content.entity.Content;
import com.pigatron.web.cms.content.repository.ContentQueryBuilder;
import com.pigatron.web.cms.content.service.ContentService;
import com.pigatron.web.core.api.AbstractWriteRestController;
import com.pigatron.web.core.exception.InvalidParameterException;
import com.pigatron.web.core.exception.ResourceNotFoundException;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${url.admin}/api/cms/content", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminContentController extends AbstractWriteRestController<Content> {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/page", method = RequestMethod.GET, params = {"urlKey"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get page by URL Key")
    public Content getPageByUrlKey(@RequestParam("urlKey") String urlKey) {
        if(urlKey == null) {
            throw new InvalidParameterException("urlKey cannot be null");
        }
        return contentService.getPageByUrlKey(urlKey).orElseThrow(ResourceNotFoundException::new);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get with query")
    public List<Content> query(ContentQueryBuilder query) {
        return contentService.query(query);
    }

}
