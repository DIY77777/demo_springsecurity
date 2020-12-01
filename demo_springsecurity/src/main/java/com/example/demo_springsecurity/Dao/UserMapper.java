package com.example.demo_springsecurity.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo_springsecurity.Model.Users;
import org.springframework.stereotype.Repository;


/**
 * Created by 关 on 2020/11/21 16:07
 */
@Repository
public interface UserMapper extends BaseMapper<Users> {
}
