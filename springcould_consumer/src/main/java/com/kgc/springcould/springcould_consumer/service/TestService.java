package com.kgc.springcould.springcould_consumer.service;

import com.kgc.springcould.springcould_consumer.pojo.Student;
import com.kgc.springcould.springcould_consumer.utils.HystrixFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//定义接口：一个接口一个服务
@FeignClient(value = "SPRING-PROVIDER",fallbackFactory = HystrixFallbackFactory.class)
public interface TestService {
    //一个服务请求一个对应方法 ，请求参数为方法参数，请求返回的数据和方法返回值对应
    //分析服务请求：其请求名：getStudent、 请求参数：无 返回的数据（json格式）
    //编写方法调用服务

    /*
    @RequestMapping(value = "/get",method = RequestMethod.POST)
    @GetMapping   //等作用于@RequestMapping(value = "/get",method = RequestMethod.GET)
    @PostMapping  //等作用于@RequestMapping(value = "/get",method = RequestMethod.POST)
    @PutMapping
    @DeleteMapping
    */


    //一请求 一方法
    @RequestMapping(value = "/GetStudent", produces = {"application/json;charset=UTF-8"})  //必须强调是json才能转化为java对象
    public Student getStudent();


}
