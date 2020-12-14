package com.zsp.comic.service;

import com.zsp.comic.entity.Video;

import java.util.List;

/**
 * @author gan
 * @create 2020-12-03 20:38
 */
public interface VideoService {
    Video getVideoById(Integer id);

    //根据动漫id查找视频资源
    List<Video> getVideoByComicId(Integer comicId);

    //根据番名查找视频资源
    List<Video> getVideoByName(String name);

    Integer addVideo(Video video);

    Integer addManyVideo(List<Video> videos);

    Integer updateVideo(Video video);

    Integer deleteVideo(Integer id);

    //根据动漫名删除视频资源
    Integer deleteVideoByName(String name);
}
