package com.pigatron.shop.catalogue.service;

import com.pigatron.shop.catalogue.entity.Image;
import com.pigatron.shop.catalogue.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image save(byte[] fileData, String mimeType) {
        Image image = new Image(fileData, mimeType);
        return imageRepository.save(image);
    }

    public Image get(String id) {
        return imageRepository.findOne(id);
    }
}
