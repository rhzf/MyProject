package com.zsp.comic.dao;

import com.zsp.comic.entity.Comic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author gan
 * @create 2020-11-30 10:56
 */
@Mapper
public interface ComicDao {
    //动漫目录页的动漫
    List<Comic> getAllComic();

    //通过id查找动漫
    Comic getComicById(Integer id);

    //通过动漫名查找动漫
    List<Comic> getComicByName(String name);

    //条件查找动漫
    List<Comic> getComicByCondition(Comic comic);

    //每日更新页的动漫，连载动漫
    List<Comic> serialComic();

    //首页的连载动漫，只是增加了返回结果限制
    List<Comic> indexSerialComic(Integer num);

    //每日推荐页的动漫，随机查找动漫，num是查找推荐动漫的数量
    List<Comic> recommendComic();

    //首页推荐动漫，只是增加了返回结果限制
    List<Comic> indexRecommendComic(Integer num);

    //获取所有地区标签
    List<String> getAllArea();

    //获取所有类型标签
    List<String> getAllType();

    //获取所有时间标签
    List<String> getAllPremiereTime();

    //获取所有状态标签
    List<String> getAllStatus();

    //获取所有剧情类型标签
    List<String> getAllPlotType();

    Integer addComic(Comic comic);

    Integer updateComic(Comic comic);

    Integer deleteComic(Integer id);
}
