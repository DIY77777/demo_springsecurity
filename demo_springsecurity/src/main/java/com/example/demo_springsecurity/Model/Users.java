package com.example.demo_springsecurity.Model;

import lombok.Data;
import java.util.List;

/**
 * Created by 关 on 2020/11/21 15:59
 */
@Data
public class Users {
    private Integer id;

    private String username;

    private String password;

    private boolean enable;

    private boolean locked;

}
