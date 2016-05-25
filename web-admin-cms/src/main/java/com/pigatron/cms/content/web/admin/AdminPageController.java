package com.pigatron.cms.content.web.admin;

import com.pigatron.admin.api.AbstractWriteRestController;
import com.pigatron.cms.content.entity.Page;
import com.pigatron.cms.content.entity.PageQuery;
import com.pigatron.cms.content.service.PageService;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "${url.admin}/api/cms/page", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminPageController extends AbstractWriteRestController<Page> {

    private PageService pageService;

    @Autowired
    public AdminPageController(PageService pageService) {
        super(pageService);
        this.pageService = pageService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, params = {"urlKey"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get by URL Key")
    public Page getByUrlKey(@RequestParam("urlKey") String urlKey) {
        return pageService.getByUrlKey(urlKey);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get with query")
    public List<Page> query() {
        PageQuery pageQuery = new PageQuery();
        return pageService.find(pageQuery);
    }

}
