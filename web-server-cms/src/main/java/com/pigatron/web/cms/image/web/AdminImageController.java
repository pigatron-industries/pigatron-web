package com.pigatron.web.cms.image.web;

import com.pigatron.web.cms.image.entity.Image;
import com.pigatron.web.cms.image.entity.ImageQueryBuilder;
import com.pigatron.web.cms.image.entity.ImagesInfo;
import com.pigatron.web.cms.image.service.ImageService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "${url.admin}/api/catalogue/image")
public class AdminImageController extends PublicImageController {

    @Autowired
    public AdminImageController(ImageService imageService) {
        super(imageService);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get with query")
    public List<Image> query(ImageQueryBuilder query) {
        return imageService.query(query);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Insert image file")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "saved successfully"),
            @ApiResponse(code = 400, message = "Validation error")})
    public Image save(@Valid @RequestBody byte[] fileData, @RequestHeader("Content-Type") String mimeType) {
        return imageService.save(fileData, mimeType);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Delete one")
    public void delete(@PathVariable String id) {
        imageService.delete(id);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get info")
    public ImagesInfo getInfo() {
        return imageService.getImagesInfo();
    }

    @RequestMapping(value = "/clearCache", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void clearCache() {
        imageService.clearCache();
    }

}
