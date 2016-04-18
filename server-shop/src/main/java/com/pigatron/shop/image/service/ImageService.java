package com.pigatron.shop.image.service;

import com.pigatron.shop.image.entity.Image;
import com.pigatron.shop.image.repository.ImageRepository;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Coordinate;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

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

    public Image getResizedImage(String id, int width, int height) throws IOException {
        Image image = get(id);
        Optional<Image> cachedResizedImage = image.findResizedImage(width, height);
        if(!cachedResizedImage.isPresent()) {
            Image resizedImage = resizeImage(image, width, height);
            image.storeResizedImage(resizedImage, width, height);
            imageRepository.save(image);
            return resizedImage;
        } else {
            return cachedResizedImage.get();
        }
    }

    private Image resizeImage(Image image, int width, int height) throws IOException {
        InputStream in = new ByteArrayInputStream(image.getFileData());

        BufferedImage resizedImage = Thumbnails.of(in).size(width, height).crop(Positions.CENTER)
                .useOriginalFormat().asBufferedImage();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "jpg", out);
        out.flush();
        return new Image(out.toByteArray(), image.getMimeType());
    }

    public void clearCache() {
        java.util.List<Image> images = imageRepository.findAll();
        images.forEach(Image::removeResizedImages);
        imageRepository.save(images);
    }
}
