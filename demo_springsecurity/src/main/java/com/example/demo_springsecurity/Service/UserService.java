package com.example.demo_springsecurity.Service;

import com.example.demo_springsecurity.Dao.UserMapper;
import com.example.demo_springsecurity.Model.Role;
import com.example.demo_springsecurity.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 关 on 2020/11/21 16:20
 */

@Service
public class UserService implements UserDetailsService{

    @Resource
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException{
        User user = userMapper.loadUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("账户不存在!");
        }
        // 我的数据库用户密码没加密，这里手动设置
        String encodePassword = passwordEncoder.encode(user.getPassword());
        System.out.println("加密后的密码：" + encodePassword);
        user.setPassword(encodePassword);
        List<Role> userRoles = userMapper.getUserRolesByUid(user.getId());
        user.setUserRoles(userRoles);
        return user;
    }

}
