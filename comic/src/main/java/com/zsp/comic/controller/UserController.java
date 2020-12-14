package com.zsp.comic.controller;

import com.zsp.comic.dao.UserDao;
import com.zsp.comic.entity.JsonResult;
import com.zsp.comic.entity.User;
import com.zsp.comic.util.ResultTool;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author gan
 * @create 2020-12-03 21:14
 */
@RestController
public class UserController {

    @Resource
    private UserDao userDao;

    @GetMapping("/admin/login")
    public String login(){
        return "ok";
    }

    @GetMapping("/getUser")
    public JsonResult getUser(){
        User user = userDao.getUserByUsername("admin");
        return ResultTool.success(user);
    }

    @GetMapping("/admin")
    public String logout(){
        return "logout success";
    }
}
