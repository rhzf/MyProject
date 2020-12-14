package com.zsp.comic.service.impl;

import com.zsp.comic.dao.MagnetDao;
import com.zsp.comic.entity.Magnet;
import com.zsp.comic.service.MagnetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gan
 * @create 2020-12-03 21:07
 */
@Service
public class MagnetServiceImpl implements MagnetService {
    @Resource
    private MagnetDao magnetDao;

    @Override
    public Magnet getMagnetById(Integer id) {
        return magnetDao.getMagnetById(id);
    }

    @Override
    public List<Magnet> getAllMagnet() {
        return magnetDao.getAllMagnet();
    }

    @Override
    public List<Magnet> getMagnetByComicId(Integer comicId) {
        return magnetDao.getMagnetByComicId(comicId);
    }

    @Override
    public List<Magnet> getMagnetByName(String name) {
        return magnetDao.getMagnetByName(name);
    }

    @Override
    public Integer addMagnet(Magnet magnet) {
        return magnetDao.addMagnet(magnet);
    }

    @Override
    public Integer updateMagnet(Magnet magnet) {
        return magnetDao.updateMagnet(magnet);
    }

    @Override
    public Integer deleteMagnet(Integer id) {
        return magnetDao.deleteMagnet(id);
    }
}
