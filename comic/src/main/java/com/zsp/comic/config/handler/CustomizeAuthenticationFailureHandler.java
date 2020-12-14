package com.zsp.comic.config.handler;

import com.alibaba.fastjson.JSON;
import com.zsp.comic.dao.UserDao;
import com.zsp.comic.entity.JsonResult;
import com.zsp.comic.entity.ResultCode;
import com.zsp.comic.util.ResultTool;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author gan
 * @create 2020-12-04 15:58
 */
@Component
public class CustomizeAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Resource
    private UserDao userDao;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        JsonResult result = null;

        if (e instanceof BadCredentialsException){
            //密码错误
            result = ResultTool.fail(ResultCode.USER_CREDENTIALS_ERROR);
        }else if(e instanceof InternalAuthenticationServiceException){
            result = ResultTool.fail(ResultCode.USER_ACCOUNT_NOT_EXIST);
        }else {
            result = ResultTool.fail(ResultCode.COMMON_FAIL);
        }
        httpServletResponse.setContentType("text/json;charset=utf-8");
        httpServletResponse.getWriter().write(JSON.toJSONString(result));
    }
}
