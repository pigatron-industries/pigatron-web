package com.pigatron.shop.image.web.customer;

import com.pigatron.admin.exception.ResourceNotFoundException;
import com.pigatron.shop.image.entity.Image;
import com.pigatron.shop.image.service.ImageService;
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
public class CustomerImageController {

    protected ImageService imageService;

    @Autowired
    public CustomerImageController(ImageService imageService) {
        this.imageService = imageService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get image file")
    public ResponseEntity<byte[]> get(@PathVariable String id) {
        Image image = imageService.get(id);
        if(image == null) {
            throw new ResourceNotFoundException();
        }
        return new ResponseEntity<>(image.getFileData(), createHeaders(image), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, params={"h", "w"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get resized image file")
    public ResponseEntity<byte[]> get(@PathVariable String id, @RequestParam("h") int height, @RequestParam("w") int width) throws IOException {
        Image image = imageService.getResizedImage(id, width, height);
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
