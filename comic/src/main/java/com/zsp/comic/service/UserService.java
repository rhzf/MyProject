package com.zsp.comic.service;

import com.zsp.comic.entity.User;

/**
 * @author gan
 * @create 2020-12-03 16:51
 */
public interface UserService {
    User getUserByUsernameAndPassword(String username, String password);

    User getUserByUsername(String username);

    String getUserAuthorityById(Integer id);

    Integer addUser(String username,String password);

    Integer updateUser(String username,String password,Integer id);
}
