package com.zsp.comic.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsp.comic.entity.Comic;
import com.zsp.comic.entity.JsonResult;
import com.zsp.comic.entity.ResultCode;
import com.zsp.comic.service.ComicService;
import com.zsp.comic.util.ResultTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gan
 * @create 2020-12-08 10:23
 */
@RestController
@RequestMapping("/comic")
public class ComicController {

    @Resource
    private ComicService comicService;

    //判断所查单个数据是否为空
    private JsonResult hasOneData(Comic comic){
        if (comic == null){
            return ResultTool.fail(ResultCode.COMMON_FAIL);
        }else {
            return ResultTool.success(comic);
        }
    }

    //判断所查多个数据的集合是否为空
    private JsonResult hasManyData(List<Comic> comics){
        if (comics == null){
            return ResultTool.fail(ResultCode.COMMON_FAIL);
        }else {
            return ResultTool.success(comics);
        }
    }

    //判断所查多个数据的分页对象是否为空
    private JsonResult hasManyData(PageInfo<Comic> pageInfo){
        if (pageInfo == null){
            return ResultTool.fail(ResultCode.COMMON_FAIL);
        }else {
            return ResultTool.success(pageInfo);
        }
    }

    @GetMapping("/getAllComic/{page}/{size}")
    public JsonResult getAllComic(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageHelper.startPage(page,size);
        List<Comic> comics = comicService.getAllComic();

        PageInfo<Comic> pageInfo = new PageInfo<>(comics);

        return hasManyData(pageInfo);
    }

    @GetMapping("/getAllCondition")
    public JsonResult getAllCondition(){
        return ResultTool.success(comicService.getAllCondition());
    }


    @GetMapping("/getComicById/{id}")
    public JsonResult getComicById(@PathVariable Integer id){
        Comic comic = comicService.getComicById(id);
        return hasOneData(comic);
    }

    @GetMapping("/getComicByName/{page}/{size}/{name}")
    public JsonResult getComicByName(@PathVariable("page") Integer page, @PathVariable("size") Integer size, @PathVariable String name){
        PageHelper.startPage(page,size);
        List<Comic> comics = comicService.getComicByName(name);
        PageInfo<Comic> pageInfo = new PageInfo<>(comics);
        return hasManyData(pageInfo);
    }

    //按条件查询动漫（不传入条件则查询所有动漫）
    @PostMapping("/getComicByCondition/{page}/{size}")                                                              //用Comic实体来接收前台传过来的条件参数对象
    public JsonResult getComicByCondition(@PathVariable("page") Integer page, @PathVariable("size") Integer size,@RequestBody Comic condition){
        PageHelper.startPage(page,size);

        List<Comic> searchComics = comicService.getComicByCondition(condition);
        PageInfo<Comic> pageInfo = new PageInfo<>(searchComics);
        return hasManyData(pageInfo);
    }

    //每日更新页的动漫，连载动漫
    @GetMapping("/getSerialComic/{page}/{size}")
    public JsonResult getSerialComic(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageHelper.startPage(page,size);
        List<Comic> comics = comicService.serialComic();

        PageInfo<Comic> pageInfo = new PageInfo<>(comics);

        return hasManyData(pageInfo);
    }

    //首页更新页的动漫，连载动漫
    @GetMapping("/getIndexSerialComic/{num}")
    public JsonResult getIndexSerialComic(@PathVariable("num") Integer num){

        List<Comic> comics = comicService.indexSerialComic(num);

        return hasManyData(comics);
    }

    //推荐页的动漫，推荐动漫
    @GetMapping("/getRecommendComic/{page}/{size}")
    public JsonResult getRecommendComic(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageHelper.startPage(page,size);
        List<Comic> comics = comicService.recommendComic();

        PageInfo<Comic> pageInfo = new PageInfo<>(comics);

        return hasManyData(pageInfo);
    }

    //首页推荐页的动漫，推荐动漫
    @GetMapping("/getIndexRecommendComic/{num}")
    public JsonResult getIndexRecommendComic(@PathVariable("num") Integer num){
        List<Comic> comics = comicService.indexRecommendComic(num);

        return hasManyData(comics);
    }
}
