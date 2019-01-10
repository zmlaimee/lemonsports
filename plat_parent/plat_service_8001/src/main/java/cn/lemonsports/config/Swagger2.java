package cn.lemonsports.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//服务提供端配置接口文档api；一般将其配置在网关处（避免多个接口反复配置的问题）
//http://127.0.0.1:8001/swagger-ui.html
@Configuration
@EnableSwagger2
public class Swagger2 {
 
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //对外暴露服务的包,以controller的方式暴露,所以就是controller的包.
                .apis(RequestHandlerSelectors.basePackage("cn,lemonsports.controller"))
                .paths(PathSelectors.any())
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("平台服务api")
                .description("平台服务接口文档说明")
                //输入文档创建人姓名及联系方式（邮箱）
                .contact(new Contact("ZML", "", "666@qq.com"))
                .version("1.0")
                .build();
    }

}