package com.pigatron.shop.catalogue.entity;


import org.springframework.data.annotation.Id;

public class ProductImage {

    @Id
    private String id;
    private byte[] fileData;
    private String text;



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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
