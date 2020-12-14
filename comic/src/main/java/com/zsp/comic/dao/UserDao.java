package com.zsp.comic.dao;

import com.zsp.comic.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author gan
 * @create 2020-11-30 10:57
 */
@Mapper
public interface UserDao {

    User getUserByUsernameAndPassword(String username,String password);

    User getUserByUsername(String username);

    String getUserAuthorityById(Integer id);

    Integer addUser(String username,String password);

    Integer updateUser(String username,String password,Integer id);

}
