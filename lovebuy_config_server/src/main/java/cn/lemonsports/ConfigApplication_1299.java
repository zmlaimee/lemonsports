package cn.lemonsports;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//获取配置的服务端；客户端是各个需要配置的模块，在user_client模块中

/**客户端:plat_service_8001
 * 服务端和客户端都要在注册中心注册
 * 连网测试、看注册中心是否有显示
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer//启用配置中心
public class ConfigApplication_1299 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication_1299.class);
    }
}
