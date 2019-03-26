package com.cyy.springdemo.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Person {
    String name;
    @JSONField(serialize = false)
    int age;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date createTime;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.createTime = new Date();
    }

}
