package com.kgc.springcould.springcould_consumer.utils;

import com.kgc.springcould.springcould_consumer.pojo.Student;
import com.kgc.springcould.springcould_consumer.service.TestService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


//实现熔断的类   这个类  实现的是feign的熔断 这样一样 就算前面的带有视图的控制器出错了  也可以触发这个熔断
@Component  //丢到容器里面去 方便调用
public class HystrixFallbackFactory implements FallbackFactory<TestService> {
    @Override
    public TestService create(Throwable throwable) {
        System.out.println("出错了 ....实现了熔断！！！");
        return ()->new Student(101,"小王吧",21);
    }
}
