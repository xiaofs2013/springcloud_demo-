package com.kgc.springcould.springcould_consumer.controller;

import com.kgc.springcould.springcould_consumer.pojo.Student;
import com.kgc.springcould.springcould_consumer.service.TestService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/GetStuInfo")
    @ResponseBody
    public Student GetStuInfo() {

        //使用RestTemplate对象调用eureka服务的步骤
        //使用RestTemplate必须要结合ribbon使用
        //1.创建RestTemplate对象 对象在启动类里面创建了


        //2.注解restTemplate对象调用服务
        //方式一：不经过注册中心 直接访问
        //Student stu = restTemplate.getForObject("http://localhost:9002/GetStudent", Student.class);//支持将json转换为对象

        //方式二： 使用ribbon从注册中心 查询服务 进行调用 通过服务名 进行调用
        Student stu1 = restTemplate.getForObject("http://SPRING-PROVIDER/GetStudent", Student.class);

        //返回对象  还是将stu对象转化成json了
        return stu1;

    }

    @RequestMapping("/GetDistrict")
    public String GetDistrict(Model model) {
        List list = restTemplate.getForObject("http://SPRING-PROVIDER/GetDistrict", List.class);
        model.addAttribute("list", list);
        return "index";
    }


    @Autowired  //如果报错了你就在启动类里面添加feign的开关注解
    private TestService testService;

        //底层采用feign组件调用服务
        @RequestMapping("/GetDistrict1")
        @HystrixCommand(fallbackMethod = "error")  //当服务调用出错啦 ， 就调用默认方法 里面写的error就是方法名
        public String GetDistrict1(Model model) {
            Student stu = testService.getStudent();
        model.addAttribute("stu", stu);
        return "index";
    }


    //底层采用feign组件调用服务  为了展示熔断的机制 我们新建一个方法让他出错
    //因为熔断的机制 是不能和视图混在一起用的  因为基本上是给别人提供服务用的 返回json的那些方法  而不是给返回视图的用的、
    // “我现在调服务 服务挂了 我是不是在给别人提供服务？ 根据规律这边是需要返回异步数据的给别人”
    @RequestMapping("/GetDistrict2")
    @HystrixCommand(fallbackMethod = "error")  //当服务调用出错啦 ， 就调用默认方法 里面写的error就是方法名
    @ResponseBody
    public Student GetDistrict2() {
        Student stu = testService.getStudent();
        //model.addAttribute("stu", stu);
        return stu;
    }


    //当发生服务调用错语时，调用error
    public Student error(){
        System.out.println("ribbon实现断路器");
        return new Student(101,"小王吧",21);
    }




}
