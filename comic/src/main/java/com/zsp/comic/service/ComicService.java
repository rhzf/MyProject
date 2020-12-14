package com.zsp.comic.service;

import com.zsp.comic.entity.Comic;

import java.util.List;
import java.util.Map;

/**
 * @author gan
 * @create 2020-12-03 16:56
 */
public interface ComicService {
    //动漫目录页的动漫
    List<Comic> getAllComic();

    List<Map<String,List<String>>> getAllCondition();

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

    Integer addComic(Comic comic);

    Integer updateComic(Comic comic);

    Integer deleteComic(Integer id);
}
