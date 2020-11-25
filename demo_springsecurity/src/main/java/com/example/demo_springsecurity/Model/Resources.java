package com.example.demo_springsecurity.Model;

import java.util.List;

/**
 * Created by 关 on 2020/11/21 15:54
 */
public class Resources {
    private Integer id;

    private String pattern;

    private List<Role> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
