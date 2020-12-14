package com.zsp.comic.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author gan
 * @create 2020-11-30 12:43
 */
public class Comic implements Serializable {
    private Integer id;
    private String name;
    private String imageUrl;
    private String newName;
    private String area;
    private String type;
    private String originalName;
    private String otherName;
    private String premiereTime;
    private String status;
    private String author;
    private String plotType;
    private String tag;
    private String company;
    private String introduction;
    private String officialWebsite;

    //网盘资源
    private String resource;
    private String resourcePassword;

    //视频地址
    private List<Video> videos = new ArrayList<>();

    //磁力链接
    private List<Magnet> magnets = new ArrayList<>();

    //视频播放地址分组视频集合
    private List<List<Video>> videoGroup = new ArrayList<>();

    //磁力链接字母组分组磁力链接集合
    private List<List<Magnet>> magnetGroup = new ArrayList<>();

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", newName='" + newName + '\'' +
                ", area='" + area + '\'' +
                ", type='" + type + '\'' +
                ", originalName='" + originalName + '\'' +
                ", otherName='" + otherName + '\'' +
                ", premiereTime='" + premiereTime + '\'' +
                ", status='" + status + '\'' +
                ", author='" + author + '\'' +
                ", plotType='" + plotType + '\'' +
                ", tag='" + tag + '\'' +
                ", company='" + company + '\'' +
                ", introduction='" + introduction + '\'' +
                ", officialWebsite='" + officialWebsite + '\'' +
                ", resource='" + resource + '\'' +
                ", resourcePassword='" + resourcePassword + '\'' +
                ", videos=" + videos +
                ", magnets=" + magnets +
                ", videoGroup=" + videoGroup +
                ", magnetGroup=" + magnetGroup +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getPremiereTime() {
        return premiereTime;
    }

    public void setPremiereTime(String premiereTime) {
        this.premiereTime = premiereTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlotType() {
        return plotType;
    }

    public void setPlotType(String plotType) {
        this.plotType = plotType;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOfficialWebsite() {
        return officialWebsite;
    }

    public void setOfficialWebsite(String officialWebsite) {
        this.officialWebsite = officialWebsite;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResourcePassword() {
        return resourcePassword;
    }

    public void setResourcePassword(String resourcePassword) {
        this.resourcePassword = resourcePassword;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<Magnet> getMagnets() {
        return magnets;
    }

    public void setMagnets(List<Magnet> magnets) {
        this.magnets = magnets;
    }

    public List<List<Video>> getVideoGroup() {
        return videoGroup;
    }

    public void setVideoGroup(List<List<Video>> videoGroup) {
        this.videoGroup = videoGroup;
    }

    public List<List<Magnet>> getMagnetGroup() {
        return magnetGroup;
    }

    public void setMagnetGroup(List<List<Magnet>> magnetGroup) {
        this.magnetGroup = magnetGroup;
    }
}
