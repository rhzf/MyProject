package com.zsp.comic.entity;

import java.io.Serializable;

/**
 * @author gan
 * @create 2020-12-02 20:36
 */
public class Video implements Serializable {
    private Integer id;
    private Integer comicId;
    private String name;
    private String address;
    private String collect;
    private String videoUrl;

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", comicId=" + comicId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", collect='" + collect + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getComicId() {
        return comicId;
    }

    public void setComicId(Integer comicId) {
        this.comicId = comicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
