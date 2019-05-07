package com.jeson.searchroom.entity;

/**
 * ${DESCRIPTION}
 *
 * @author jeson
 * @create 2019-03-22 16:18
 **/
public class IQinNiuResponse {
    private String key;
    private String hash;
    private String bucket;
    private String w;
    private String h;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }
}
