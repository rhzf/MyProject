package com.zsp.comic.service;

import com.zsp.comic.entity.Magnet;

import java.util.List;

/**
 * @author gan
 * @create 2020-12-03 21:07
 */
public interface MagnetService {
    Magnet getMagnetById(Integer id);

    List<Magnet> getAllMagnet();

    List<Magnet> getMagnetByComicId(Integer comicId);

    //通过番名查找磁力，番名对磁力链接是一对多关系
    List<Magnet> getMagnetByName(String name);

    Integer addMagnet(Magnet magnet);

    Integer updateMagnet(Magnet magnet);

    Integer deleteMagnet(Integer id);
}
