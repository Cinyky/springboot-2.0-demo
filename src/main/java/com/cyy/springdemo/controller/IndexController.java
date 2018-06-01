package com.cyy.springdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.cyy.springdemo.utils.LoggerUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * ========================
 * Created with IntelliJ IDEA.
 *
 * @Author： Cyy
 * @Date: 2018/6/1
 * @Time: 上午11:14
 * ========================
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping(value = "/logger",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject login(HttpServletRequest request, String name) throws Exception
    {
        JSONObject obj = new JSONObject();
        obj.put("msg","用户："+name+"，登录成功。");
        //将返回值写入到请求对象中
        request.setAttribute(LoggerUtils.LOGGER_RETURN,obj);
        return obj;
    }
}

