package com.example.demo_springsecurity.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo_springsecurity.Model.Role;
import com.example.demo_springsecurity.Model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 关 on 2020/11/21 16:07
 */
@Component
public interface UserMapper extends BaseMapper<User> {
    public User loadUserByUsername(String userName);

    public List<Role> getUserRolesByUid(Integer id);
}
