package com.zsp.comic.dao;

import com.zsp.comic.entity.Video;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gan
 * @create 2020-11-30 10:57
 */
@Mapper
public interface VideoDao {
    Video getVideoById(Integer id);

    //根据动漫id查找视频资源
    List<Video> getVideoByComicId(Integer comicId);

    //根据番名查找视频资源
    List<Video> getVideoByName(String name);

    //通过id查找当前番所有视频链接分组
    List<String> getVideoAddressGroupByComicId(Integer comicId);

    Integer addVideo(Video video);

    Integer addManyVideo(List<Video> videos);

    Integer updateVideo(Video video);

    //待定
    Integer updateManyVideo(List<Video> videos);

    Integer deleteVideo(Integer id);

    //根据动漫名删除视频资源
    Integer deleteVideoByName(String name);

}
