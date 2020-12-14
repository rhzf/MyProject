package com.zsp.comic.service.impl;

import com.zsp.comic.dao.UserDao;
import com.zsp.comic.entity.Authority;
import com.zsp.comic.entity.User;
import com.zsp.comic.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gan
 * @create 2020-12-03 16:51
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        User user = userDao.getUserByUsernameAndPassword(username, password);
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        return user;
    }

    @Override
    public String getUserAuthorityById(Integer id) {
        String authority = userDao.getUserAuthorityById(id);
        return authority;
    }

    @Override
    public Integer addUser(String username, String password) {
        Integer num = userDao.addUser(username, password);
        return num;
    }

    @Override
    public Integer updateUser(String username, String password, Integer id) {
        Integer num = userDao.updateUser(username, password, id);
        return num;
    }
}
