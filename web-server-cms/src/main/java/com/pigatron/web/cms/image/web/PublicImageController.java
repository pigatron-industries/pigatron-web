package com.pigatron.web.cms.image.web;

import com.pigatron.web.cms.image.entity.Image;
import com.pigatron.web.cms.image.service.ImageService;
import com.pigatron.web.core.exception.ResourceNotFoundException;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "${url.public}/api/catalogue/image")
public class PublicImageController {

    protected ImageService imageService;

    @Autowired
    public PublicImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get image file")
    public ResponseEntity<byte[]> get(@PathVariable String id,
                                      @RequestParam(value="h", required=false) Integer height,
                                      @RequestParam(value="w", required=false) Integer width) throws IOException {
        Image image;
        if(height == null && width == null) {
            image = imageService.findOne(id);
        } else {
            image = imageService.getResizedImage(id, width, height);
        }

        if(image == null) {
            throw new ResourceNotFoundException();
        }
        return new ResponseEntity<>(image.getFileData(), createHeaders(image), HttpStatus.OK);
    }

    private HttpHeaders createHeaders(Image image) {
        String[] mimeType = image.getMimeType().split("/");
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(new MediaType(mimeType[0], mimeType[1]));
        return responseHeaders;
    }

}
