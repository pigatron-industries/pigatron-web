package com.pigatron.cms.image.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Document
public class Image {

    @Id private String id;
    @JsonIgnore private byte[] fileData;
    @JsonIgnore private String mimeType;
    private String text;
    @JsonIgnore private Map<String, byte[]> resizedImages;

    public Image() {
        this.resizedImages = new HashMap<>();
    }

    public Image(byte[] fileData, String mimeType) {
        this();
        this.fileData = fileData;
        this.mimeType = mimeType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, byte[]> getResizedImages() {
        return resizedImages;
    }

    public void setResizedImages(Map<String, byte[]> resizedImages) {
        this.resizedImages = resizedImages;
    }

    public Optional<Image> findResizedImage(int width, int height) {
        String key = createResizedImageKey(width, height);
        byte[] bytes = resizedImages.get(key);
        if(bytes != null) {
            return Optional.of(new Image(bytes, mimeType));
        } else {
            return Optional.empty();
        }
    }

    public void storeResizedImage(Image resizedImage, int width, int height) {
        String key = createResizedImageKey(width, height);
        resizedImages.put(key, resizedImage.getFileData());
    }

    public void removeResizedImages() {
        resizedImages.clear();
    }

    private String createResizedImageKey(int width, int height) {
        return width + "x" + height;
    }
}
