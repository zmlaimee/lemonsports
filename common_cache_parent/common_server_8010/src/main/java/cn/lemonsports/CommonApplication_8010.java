package cn.lemonsports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 缓存服务端
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "cn.lemonsports")
public class CommonApplication_8010 {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication_8010.class);
    }
}
