package com.example.demo_springsecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

/**
 * Created by 关 on 2020/12/1 9:13
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/error/403.html");

        http.formLogin()   //自定义自己编写的登录页面
            .loginPage("/login.html")  //登录页面设置
            .loginProcessingUrl("/user/login")// 登录访问路径
            .defaultSuccessUrl("/index").permitAll()  //登录成功之后跳转的路径
            .and().authorizeRequests()
                .antMatchers("/","/hello","/user/login").permitAll() //可以直接访问的路径，不需要认证
                //当前登录用户，只有admins的权限才可以进入  在UserDetailsService中的
                //List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList
                //中进行设置  没有访问权限时返回 status = 403
                //hasAuthority 为单个权限设置，多个权限被限制
                //.antMatchers("/index").hasAuthority("admins,manager")
                //hasAnyAuthority  为其中有任一权限即可
                .antMatchers("/index").hasAnyAuthority("admins")
                //hasRole 单个角色 设置角色，show被赋值后在源码中被改变为 ROLE_show  在在UserDetailsService中手动变为ROLE_show
                //.antMatchers("/index").hasRole("sale")
                //hasAnyRole 有其中任一角色即可
                .antMatchers("/index").hasAnyRole("sale")
                .anyRequest().authenticated()
            .and().csrf().disable();  //关闭csrf防护
    }
}
