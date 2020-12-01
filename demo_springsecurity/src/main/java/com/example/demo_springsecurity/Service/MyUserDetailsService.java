package com.example.demo_springsecurity.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo_springsecurity.Dao.UserMapper;
import com.example.demo_springsecurity.Model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Created by 关 on 2020/11/21 16:20
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<Users> wrapper = new QueryWrapper();

        wrapper.eq("username",username);
        Users users = userMapper.selectOne(wrapper);

        if(users == null){
            throw new UsernameNotFoundException("用户名不存在");
        }

        //数据库查出用户信息
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_sale");
        //不加密密码
        return new User(users.getUsername(),new BCryptPasswordEncoder().encode(users.getPassword()),auths);
    }
}
