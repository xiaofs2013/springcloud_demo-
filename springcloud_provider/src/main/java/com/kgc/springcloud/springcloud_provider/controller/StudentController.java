package com.kgc.springcloud.springcloud_provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@ResponseBody
//上面两个注解其实可以合并为一个叫：@RestController的注解
public class StudentController {

    //编写的是一个控制器  提供的却是服务  （因为他返回数据了）  这个就叫做前后台分离或者控制器就是服务
    //一个控制器方法就是一个服务
    @RequestMapping("/GetStudent")
    public String GetStudent(){
        System.out.println("我是服务提供者A");
        return "{\"num\":1002,\"name\":\"阿轩\",\"age\":23}";   //返回的数据是json格式
    }


}
