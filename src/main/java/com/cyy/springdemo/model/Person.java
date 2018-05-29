package com.cyy.springdemo.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Person {
    String name;
    @JSONField(serialize=false)
    int age;

    @JSONField(format = "yyyy-MM-dd HH:mm")
    private Date createTime;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.createTime = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
