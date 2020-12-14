package com.zsp.comic.dao;

import com.zsp.comic.entity.Magnet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gan
 * @create 2020-11-30 10:58
 */
@Mapper
public interface MagnetDao {
    Magnet getMagnetById(Integer id);

    List<Magnet> getAllMagnet();

    List<Magnet> getMagnetByComicId(Integer comicId);

    //通过番名查找磁力，番名对磁力链接是一对多关系
    List<Magnet> getMagnetByName(String name);

    //通过id查找当前番所有磁力链接字幕组分组
    List<String> magnetLetterGroupByComicId(Integer comicId);

    Integer addMagnet(Magnet magnet);

    Integer updateMagnet(Magnet magnet);

    Integer deleteMagnet(Integer id);
}
