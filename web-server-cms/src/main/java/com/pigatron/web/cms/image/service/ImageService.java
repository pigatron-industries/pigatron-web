package com.pigatron.web.cms.image.service;

import com.pigatron.web.cms.image.entity.Image;
import com.pigatron.web.cms.image.entity.ImagesInfo;
import com.pigatron.web.cms.image.repository.ImageRepository;
import com.pigatron.web.core.service.AbstractRepositoryService;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@Service
public class ImageService extends AbstractRepositoryService<Image> {

    private ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        super(imageRepository);
        this.imageRepository = imageRepository;
    }

    public Image save(byte[] fileData, String mimeType) {
        Image image = new Image(fileData, mimeType);
        return save(image);
    }

    @Override
    public Image save(Image image) {
        Optional<Image> existingImage = getExistingImage(image);
        if(existingImage.isPresent()) {
            return existingImage.get();
        } else {
            return super.save(image);
        }
    }

    public Image getResizedImage(String id, Integer width, Integer height) throws IOException {
        Image image = findById(id);
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

    private Image resizeImage(Image image, Integer width, Integer height) throws IOException {
        InputStream in = new ByteArrayInputStream(image.getFileData());

        BufferedImage resizedImage = null;
        if(width != null && height != null) {
            resizedImage = Thumbnails.of(in).size(width, height).crop(Positions.CENTER)
                    .useOriginalFormat().asBufferedImage();
        } else if(width == null && height != null) {
            resizedImage = Thumbnails.of(in).height(height).keepAspectRatio(true)
                    .useOriginalFormat().asBufferedImage();
        } else if(width != null && height == null) {
            resizedImage = Thumbnails.of(in).width(width).keepAspectRatio(true)
                    .useOriginalFormat().asBufferedImage();
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "jpg", out);
        out.flush();
        return new Image(out.toByteArray(), image.getMimeType());
    }

    public void clearCache() {
        java.util.List<Image> images = imageRepository.findAll();
        images.forEach(Image::removeResizedImages);
        images.forEach(i -> imageRepository.save(i));
    }

    private Optional<Image> getExistingImage(Image inputImage) {
        List<Image> allImages = imageRepository.findAll();
        return allImages.stream().filter(image -> image.equals(inputImage)).findAny();
    }

    public ImagesInfo getImagesInfo() {
        int filesSize = 0;
        int cachedFilesSize = 0;

        List<Image> allImages = imageRepository.findAll();
        for (Image image : allImages) {
            filesSize += image.getFileSize();
            cachedFilesSize += image.getCachedFilesSize();
        }

        return new ImagesInfo(filesSize, cachedFilesSize);
    }
}
