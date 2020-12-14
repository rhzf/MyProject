package com.zsp.comic.service.impl;

import com.zsp.comic.dao.UserDao;
import com.zsp.comic.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author gan
 * @create 2020-12-03 21:32
 */
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserDao userDao;

    //实现自定义用户认证的核心逻辑，loadUserByUsername(String username)的参数就是登录时提交的用户名，
    //返回类型是一个叫UserDetails 的接口，需要在这里构造出他的一个实现类User，这是Spring security提供的用户信息实体。
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.getUserByUsername(username);

        if (user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        String authority = userDao.getUserAuthorityById(user.getId());

        //获取权限列表
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(authority);

        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),auths);
    }

//    //给密码加密
//    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        System.out.println(encoder.encode("admin"));//$2a$10$JLUZAbF6dZNUlhSIsaroXOny9ca1NLoDtxj8Ej5SPGw6CbO5.E1Fy
//    }
}
