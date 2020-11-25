package com.example.demo_springsecurity.Model;

import java.io.Serializable;

/**
 * Created by 关 on 2020/11/21 15:57
 */
public class Role implements Serializable{
    private static final long serialVersionUID = 825384782616737527L;

    private Integer id;

    private String name;

    private String description;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
