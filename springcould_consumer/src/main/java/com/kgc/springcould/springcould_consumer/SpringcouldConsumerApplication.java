package com.kgc.springcould.springcould_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient      //启动客户端
@EnableFeignClients  //开启Feign
@EnableHystrix    //开启熔断支持
@EnableHystrixDashboard   //熔断错误显示器
public class SpringcouldConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcouldConsumerApplication.class, args);
    }


    //Bean标签 可以自动帮我们在容器里面创建Bean  和Spring里面的Bean标签功能是一样的 好处是谁都可以掉 因为放在容器内
    @Bean
    @LoadBalanced   //支持使用服务名称发现服务
    public RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

}
