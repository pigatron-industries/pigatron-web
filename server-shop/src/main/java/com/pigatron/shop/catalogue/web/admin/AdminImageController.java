package com.pigatron.shop.catalogue.web.admin;

import com.pigatron.server.web.exception.ResourceNotFoundException;
import com.pigatron.shop.catalogue.entity.Image;
import com.pigatron.shop.catalogue.service.ImageService;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "${url.admin}/api/catalogue/image")
public class AdminImageController {

    private ImageService imageService;

    @Autowired
    public AdminImageController(ImageService imageService) {
        this.imageService = imageService;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get image file")
    public ResponseEntity<byte[]> get(@PathVariable String id) {
        Image image = imageService.get(id);
        if(image == null) {
            throw new ResourceNotFoundException();
        }
        String[] mimeType = image.getMimeType().split("/");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(new MediaType(mimeType[0], mimeType[1]));
        return new ResponseEntity<>(image.getFileData(), responseHeaders, HttpStatus.OK);
    }

}
