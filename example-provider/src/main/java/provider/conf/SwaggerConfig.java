package provider.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Spring Boot 项目测试全流程 Swagger 实例文档",
                "集成各种测试的过程",
                "API V1.0",
                "Terms of service",
                new Contact("Frank.Chen", "http://test.test.com", "cjt0226@qq.com"),
                "Apache", "http://www.apache.org/", Collections.emptyList());
    }
}
//
//@Configuration
//@EnableWebMvc
//@EnableSwagger2
//public class SwaggerConfig extends WebMvcConfigurationSupport {
////public class SwaggerConfig {
//    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.learning.test.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    // 构建api文档的详细信息
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                // 页面标题
//                .title("API接口说明")
//                // 创建人
//                .contact(new Contact("lasdaybg", "", ""))
//                // 版本号
//                .version("")
//                // 描述
//                .description("")
//                .build();
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/META-INF/resources/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//    }
//}