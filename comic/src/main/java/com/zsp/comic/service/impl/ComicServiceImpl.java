package com.zsp.comic.service.impl;

import com.zsp.comic.dao.ComicDao;
import com.zsp.comic.dao.MagnetDao;
import com.zsp.comic.dao.VideoDao;
import com.zsp.comic.entity.Comic;
import com.zsp.comic.entity.Magnet;
import com.zsp.comic.entity.Video;
import com.zsp.comic.service.ComicService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author gan
 * @create 2020-12-03 16:56
 */
@Service
public class ComicServiceImpl implements ComicService {
    @Resource
    private ComicDao comicDao;

    @Resource
    private VideoDao videoDao;

    @Resource
    private MagnetDao magnetDao;

    //将视频和磁力链接分组插入
    private void getOneComicDetail(Comic comic){
        if (comic != null){
            List<Video> videos = videoDao.getVideoByComicId(comic.getId());

            //如果视频集不为空则通过播放地址筛选插入视频分组集合
            if (videos != null){

                List<String> addressGroup = videoDao.getVideoAddressGroupByComicId(comic.getId());
                List<List<Video>> videoGroup = new ArrayList<>();

                for (String group:addressGroup){
                    List<Video> childVideos = new ArrayList<>();
                    for(Video video : videos ){
                        if (group.equals(video.getAddress())){
                            childVideos.add(video);
                        }
                    }

                    if (childVideos != null){
                        videoGroup.add(childVideos);
                    }

                }

                if (videoGroup != null){
                    comic.setVideoGroup(videoGroup);
                }
            }

            List<Magnet> magnets = magnetDao.getMagnetByComicId(comic.getId());

            //如果磁力集不为空则通过字幕组筛选插入字幕组分组集合
            if (magnets != null){
                List<String> letterGroup = magnetDao.magnetLetterGroupByComicId(comic.getId());
                List<List<Magnet>> magnetGroup = new ArrayList<>();
                for (String letter : letterGroup){
                    List<Magnet> childMagnets = new ArrayList<>();
                    for (Magnet magnet : magnets){

                        //字幕组可以为空，为空时就是生肉或者未知字幕组了
                        if (letter == magnet.getLetter()){
                            childMagnets.add(magnet);
                        }
                    }
                    magnetGroup.add(childMagnets);
                }
                if (magnetGroup != null){
                    comic.setMagnetGroup(magnetGroup);
                }
            }
        }
    }

    private void getManyComicDetail(List<Comic> comics){
        if (comics != null){
            for (Comic comic:comics){
                getOneComicDetail(comic);
            }
        }
    }

    @Override
    public List<Comic> getAllComic() {
        return comicDao.getAllComic();
    }

    //去除查询条件的所有重复条件
    private List<String> removeRepeat(List<String> tags){

        if (tags != null){
            Set set = new HashSet();
            List newTags = new ArrayList();
            for (String cd:tags) {
                if(set.add(cd)){
                    newTags.add(cd);
                }
            }

            return newTags;
        }

        return null;
    }

    //去除当前从数据库查出来标签的null值（比如地区条件：areas）
    private void removeNull(String tagName,List<Map<String,List<String>>> conditionList,List<String> tags){
        if (tags != null){
            Map<String,List<String>> tagMap = new HashMap<>();

            //这个一行用做去除tags中的null值
            tags.removeAll(Collections.singleton(null));

            tagMap.put(tagName,removeRepeat(tags));

            conditionList.add(tagMap);
        }
    }

    //获取所有筛选条件（目录页使用）
    @Override
    public List<Map<String,List<String>>> getAllCondition() {
        List<String> areas = comicDao.getAllArea();
        List<String> types = comicDao.getAllType();
        List<String> premiereTime = comicDao.getAllPremiereTime();
        List<String> status = comicDao.getAllStatus();
        List<String> plotTypes = comicDao.getAllPlotType();

        List<Map<String,List<String>>> condition = new ArrayList<>();

//        这一行一块代码抽取放到removeNull()方法中，使得代码不那么臃肿
//        if (areas != null){
//            Map<String,List<String>> areaMap = new HashMap<>();
//            areas.removeAll(Collections.singleton(null));
//
//            areaMap.put("地区",removeRepeat(areas));
//
//            condition.add(areaMap);
//        }

        removeNull("地区",condition,areas);

//        if (types != null){
//            Map<String,List<String>> typeMap = new HashMap<>();
//            types.removeAll(Collections.singleton(null));
//
//            typeMap.put("动画种类",removeRepeat(types));
//
//            condition.add(typeMap);
//        }

        removeNull("动画种类",condition,types);

        if (premiereTime != null){
            Map<String,List<String>> premiereTimeMap = new HashMap<>();
            List<String> years = new ArrayList<>();
            premiereTime.removeAll(Collections.singleton(null));
            for (String time : premiereTime){
                if (time != null){
                    String[] year = time.split("-");
                    years.add(year[0]);
                }
            }

            premiereTimeMap.put("时间",removeRepeat(years));

            condition.add(premiereTimeMap);
        }

//        if (status != null){
//            Map<String,List<String>> statusMap = new HashMap<>();
//            status.removeAll(Collections.singleton(null));
//
//            statusMap.put("状态",removeRepeat(status));
//
//            condition.add(statusMap);
//        }

        removeNull("状态",condition,status);

        if (plotTypes != null){
            Map<String,List<String>> plotTypeMap = new HashMap<>();
            List<String> pts = new ArrayList<>();

            for (String plotType : plotTypes){
                if (plotType != null){
                    String[] pt = plotType.split(" ");
                    for (int i = 0; i < pt.length; i++) {
                        pts.add(pt[i]);
                    }
                }

            }

            pts.removeAll(Collections.singleton(null));

            plotTypeMap.put("剧情类型",removeRepeat(pts));

            condition.add(plotTypeMap);
        }

        return condition;
    }

    @Override
    public Comic getComicById(Integer id) {
        Comic comic = comicDao.getComicById(id);
        getOneComicDetail(comic);
        return comic;
    }

    @Override
    public List<Comic> getComicByName(String name) {
        List<Comic> comics = comicDao.getComicByName(name);
        getManyComicDetail(comics);
        return comics;
    }

    @Override
    public List<Comic> getComicByCondition(Comic comic) {
        List<Comic> comics = comicDao.getComicByCondition(comic);
        //getManyComicDetail(comics);
        return comics;
    }

    @Override
    public List<Comic> serialComic() {
        List<Comic> comics = comicDao.serialComic();
        //getManyComicDetail(comics);
        return comics;
    }

    @Override
    public List<Comic> indexSerialComic(Integer num) {
        List<Comic> comics = comicDao.indexSerialComic(num);
        //getManyComicDetail(comics);
        return comics;
    }

    @Override
    public List<Comic> recommendComic() {
        List<Comic> comics = comicDao.recommendComic();
        //getManyComicDetail(comics);
        return comics;
    }

    @Override
    public List<Comic> indexRecommendComic(Integer num) {
        List<Comic> comics = comicDao.indexRecommendComic(num);
        //getManyComicDetail(comics);
        return comics;
    }

    @Override
    public Integer addComic(Comic comic) {
        Integer num = comicDao.addComic(comic);
        return num;
    }

    @Override
    public Integer updateComic(Comic comic) {
        Integer num = comicDao.updateComic(comic);
        return num;
    }

    @Override
    public Integer deleteComic(Integer id) {
        Integer num = comicDao.deleteComic(id);
        return num;
    }
}
