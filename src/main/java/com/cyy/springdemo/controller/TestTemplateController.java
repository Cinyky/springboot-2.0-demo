package com.cyy.springdemo.controller;

import com.cyy.springdemo.model.Person;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestTemplateController {

    @RequestMapping("/")
    @ResponseBody
    Person home(){
        Person p = new Person("1",1);
        return p;
    }


    @RequestMapping("/index")
    String template(Model model){
        Person p = new Person("1",1);
        List<Person> people = new ArrayList<>();
        Person p1 = new Person("1",1);
        Person p2 = new Person("2",2);
        people.add(p1);
        people.add(p2);
        model.addAttribute("singlePerson",p);
        model.addAttribute("people",people);
        return "index";
    }

}
