package com.bbd.dafei.web.config;

import com.bbd.dafei.common.util.PageInfo;
import com.bbd.dafei.common.util.PageInfoIgnore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.URLEncoder;

/**
 * swagger2配置
 * Created by wish on 2017/4/14.
 */
@Configuration  //说明这个是spring的设置
//@EnableWebMvc   //不是SpringBoot需要引入这个
@EnableSwagger2 //开启Swagger2
@ComponentScan("com.bbd.dafei.**.controller")  //指定被扫描Controller的位置
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  //Docket，Springfox的私有API设置初始化为Swagger2
                .select()
                .paths(PathSelectors.any())
                .build()
                .ignoredParameterTypes(PageInfoIgnore.class)
                .apiInfo(new ApiInfoBuilder()  //设置API文档的主体说明
                        .title("红警")
                        .description("红警API")
                        .version("2.0")
                        .termsOfServiceUrl("http://localhost:8888/")
                        .build());

    }

}