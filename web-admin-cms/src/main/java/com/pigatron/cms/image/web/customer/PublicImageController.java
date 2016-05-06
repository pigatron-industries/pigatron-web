package com.pigatron.cms.image.web.customer;

import com.pigatron.admin.exception.ResourceNotFoundException;
import com.pigatron.cms.image.service.ImageService;
import com.pigatron.cms.image.entity.Image;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "${url.shop}/api/catalogue/image")
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
        Image image = null;
        if(height == null && width == null) {
            image = imageService.get(id);
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
