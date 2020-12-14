package com.zsp.comic.entity;

import java.io.Serializable;

/**
 * @author gan
 * @create 2020-11-30 14:58
 */
public class Magnet implements Serializable {
    private Integer id;
    private Integer comicId;
    private String name;
    private String letter;
    private String imageUrl;
    private String collect;
    private String magnet;

    @Override
    public String toString() {
        return "Magnet{" +
                "id=" + id +
                ", comicId=" + comicId +
                ", name='" + name + '\'' +
                ", letter='" + letter + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", collect='" + collect + '\'' +
                ", magnet='" + magnet + '\'' +
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

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getMagnet() {
        return magnet;
    }

    public void setMagnet(String magnet) {
        this.magnet = magnet;
    }
}
