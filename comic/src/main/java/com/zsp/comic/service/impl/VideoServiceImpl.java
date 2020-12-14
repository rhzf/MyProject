package com.zsp.comic.service.impl;

import com.zsp.comic.dao.VideoDao;
import com.zsp.comic.entity.Video;
import com.zsp.comic.service.VideoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gan
 * @create 2020-12-03 20:38
 */
@Service
public class VideoServiceImpl implements VideoService {

    @Resource
    private VideoDao videoDao;

    @Override
    public Video getVideoById(Integer id) {
        return videoDao.getVideoById(id);
    }

    @Override
    public List<Video> getVideoByComicId(Integer comicId) {
        return videoDao.getVideoByComicId(comicId);
    }

    @Override
    public List<Video> getVideoByName(String name) {
        return videoDao.getVideoByName(name);
    }

    @Override
    public Integer addVideo(Video video) {
        return videoDao.addVideo(video);
    }

    @Override
    public Integer addManyVideo(List<Video> videos) {
        return videoDao.addManyVideo(videos);
    }

    @Override
    public Integer updateVideo(Video video) {
        return videoDao.updateVideo(video);
    }

    @Override
    public Integer deleteVideo(Integer id) {
        return videoDao.deleteVideo(id);
    }

    @Override
    public Integer deleteVideoByName(String name) {
        return videoDao.deleteVideoByName(name);
    }
}
