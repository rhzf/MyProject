package com.zsp.comic.config;

import com.zsp.comic.config.handler.CustomizeAuthenticationEntryPoint;
import com.zsp.comic.config.handler.CustomizeAuthenticationFailureHandler;
import com.zsp.comic.config.handler.CustomizeAuthenticationSuccessHandler;
import com.zsp.comic.config.handler.CustomizeLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author gan
 * @create 2020-12-03 21:28
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private CustomizeAuthenticationSuccessHandler authenticationSuccessHandler;

    @Resource
    private CustomizeAuthenticationFailureHandler authenticationFailureHandler;

    @Resource
    private CustomizeLogoutSuccessHandler logoutSuccessHandler;

    //将加密规则 注入到spring容器中
    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置认证方式
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http相关的配置，包括登入登出、异常处理、会话管理等
        http.cors().and().csrf().disable();
        http.authorizeRequests().
                antMatchers("/getUser").hasAuthority("ROLE_admin").
                //异常处理(权限拒绝、登录失效等)
                and().exceptionHandling().
                authenticationEntryPoint(authenticationEntryPoint). //匿名用户访问无权限资源时的异常处理
                and().
                formLogin().
                successHandler(authenticationSuccessHandler).
                failureHandler(authenticationFailureHandler).
                and().logout().
                logoutSuccessHandler(logoutSuccessHandler);
    }
}
