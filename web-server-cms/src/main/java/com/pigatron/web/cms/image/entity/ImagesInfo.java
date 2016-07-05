package com.pigatron.web.cms.image.entity;


public class ImagesInfo {

    private int filesSize;

    private int cachedFilesSize;

    public ImagesInfo(int filesSize, int cachedFilesSize) {
        this.filesSize = filesSize;
        this.cachedFilesSize = cachedFilesSize;
    }

    public int getFilesSize() {
        return filesSize;
    }

    public int getCachedFilesSize() {
        return cachedFilesSize;
    }
}
