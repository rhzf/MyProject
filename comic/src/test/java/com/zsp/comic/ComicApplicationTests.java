package com.zsp.comic;

import com.zsp.comic.dao.ComicDao;
import com.zsp.comic.dao.MagnetDao;
import com.zsp.comic.dao.UserDao;
import com.zsp.comic.dao.VideoDao;
import com.zsp.comic.entity.*;

import com.zsp.comic.service.ComicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
class ComicApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private UserDao userDao;

    @Resource
    private ComicDao comicDao;

    @Resource
    private ComicService comicService;

    @Resource
    private VideoDao videoDao;


    @Test
    public void userTest(){
//        User user = userDao.getUserByUsernameAndPassword("lly", "1234");
//        System.out.println(user);

//        User user2 = userDao.getUserByUsername("lly");
//        System.out.println(user2);

//        Authority authority = userDao.getUserAuthority(2);
//        System.out.println(authority);

//        Integer num = userDao.addUser("user", "user");
//        System.out.println(num);//1

//        Integer num2 = userDao.updateUser("admin", "admin", 3);
//        System.out.println(num2);//1
    }

    @Test
    public void comicTest(){
//        List<Comic> comics = comicDao.getAllComic();
//        for (Comic comic:comics){
//            List<Video> videos = videoDao.getVideoByName(comic.getName());
//            List<Magnet> magnets = magnetDao.getMagnetByName(comic.getName());
//            comic.setVideos(videos);
//            comic.setMagnets(magnets);
//            System.out.println(comic);
//        }

//        Comic comic2 = comicDao.getComicById(55);
//        System.out.println(comic2);

//        List<Comic> comic3 = comicDao.getComicByName("");
//        for(Comic comic : comic3){
//            System.out.println(comic);
//        }

//        List<Comic> comic4 = comicDao.getDetailComicByName("魔");
//        for(Comic comic : comic4){
//            System.out.println(comic);
//        }

//        Calendar c1 = Calendar.getInstance();
//        c1.set(2020,4,4);
//        Date date = c1.getTime();
//
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy");
//        //System.out.println("时间："+ft.format(date));
//
        Comic comicDetail1 = new Comic();
//        comicDetail1.setArea("日本");
//        comicDetail1.setType("TV");
//        comicDetail1.setPremiereTime("2020");
//        comicDetail1.setStatus("连载");
//        comicDetail1.setPlotType("校园");
        List<Comic> comicByCondition = comicDao.getComicByCondition(comicDetail1);
        for (Comic comicDetail:comicByCondition){
            System.out.println(comicDetail);
        }


//        List<Comic> comic5 = comicDao.serialComic();
//        for(Comic comic : comic5){
//            System.out.println(comic);
//        }

//        List<Comic> comic6 = comicDao.indexSerialComic(8);
//        for(Comic comic : comic6){
//            System.out.println(comic);
//        }

//        List<Comic> comic7 = comicDao.recommendComic();
//        for(Comic comic : comic7){
//            System.out.println(comic);
//        }

//        List<Comic> comic8 = comicDao.indexRecommendComic(3);
//        for(Comic comic : comic8){
//            System.out.println(comic);
//        }

//        List<String> areas = comicDao.getAllArea();
//        System.out.println(areas);

//        Comic comic9 = new Comic("111", "222", "333", "444", "555", "666", "777", "888", "999", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700");
//        Integer num = comicDao.addComic(comic9);
//        System.out.println(num); //1

//        Comic comic10 = new Comic(77, "11111111111111", "222", "333", "444", "555", "666", "777", "888", "999", "1000", "1100", "1200", "1300", "1400", "1500", "1600", "1700");
//        Integer num2 = comicDao.updateComic(comic10);
//        System.out.println(num2);//1

//        Integer num3 = comicDao.deleteComic(77);
//        System.out.println(num3);//1


        //service
//        Comic comic8 = comicService.getComicById(72);
//        System.out.println(comic8);
//        for (Magnet magnet : comic8.getMagnets()){
//            System.out.println(magnet.getLetter()==null);
//        }


//        List<Comic> comics9 = comicService.getComicByName("魔");
//        for (Comic comic:comics9){
//            System.out.println(comic);
//        }

//        String year = "冒险 奇幻 战斗";
//        String[] y = year.split(" ");
//        for (int i = 0; i < y.length; i++) {
//            System.out.println(i+":"+y[i]);
//        }

//        List<Map<String, List<String>>> list = comicService.getAllCondition();
//        for (Map<String,List<String>> map : list){
//            for (Map.Entry<String,List<String>> entry : map.entrySet()){
//                System.out.println("title: "+entry.getKey()+",list: "+entry.getValue());
//            }
//        }

    }

    @Resource
    private MagnetDao magnetDao;

    @Test
    public void magnetTest(){
//        Magnet magnet1 = magnetDao.getMagnetById(1);
//        System.out.println(magnet1);

//        List<Magnet> magnets2 = magnetDao.getAllMagnet();
//        for (Magnet magnet:magnets2){
//            System.out.println(magnet);
//        }

//        List<Magnet> magnet3 = magnetDao.getMagnetByName("铁路浪漫谭");
//        for (Magnet magnet:magnet3){
//            System.out.println(magnet);
//        }

//        Magnet magnet4 = new Magnet("11", "22", "33", "44");
//        Integer num1 = magnetDao.addMagnet(magnet4);
//        System.out.println(num1);//1

//        Magnet magnet5 = new Magnet(3197,"111111", "22222", "333333", "444444");
//        Integer num2 = magnetDao.updateMagnet(magnet5);
//        System.out.println(num2);//1

//        Integer num3 = magnetDao.deleteMagnet(3197);
//        System.out.println(num3);//1

//        List<String> group = magnetDao.magnetLetterGroupByComicId(59);
//        System.out.println(group);
    }

    @Test
    public void videoTest(){
//        Video video1 = videoDao.getVideoById(1);
//        System.out.println(video1);

//        List<Video> videos2 = videoDao.getVideoByName("总之就是非常可爱");
//        for (Video video:videos2){
//            System.out.println(video);
//        }

//        List<String> group = videoDao.getVideoAddressGroupByComicId(1);
//        System.out.println(group);

    }
}
