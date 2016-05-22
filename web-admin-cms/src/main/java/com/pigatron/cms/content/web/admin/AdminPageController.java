package com.pigatron.cms.content.web.admin;

import com.pigatron.admin.api.AbstractWriteRestController;
import com.pigatron.cms.content.entity.Page;
import com.pigatron.cms.content.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "${url.admin}/api/cms/page", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminPageController extends AbstractWriteRestController<Page> {

    private PageService pageService;

    @Autowired
    public AdminPageController(PageService pageService) {
        super(pageService);
        this.pageService = pageService;
    }

}
