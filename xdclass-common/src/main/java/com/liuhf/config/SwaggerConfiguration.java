package com.liuhf.config;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/
@Component
@Data
@EnableOpenApi
public class SwaggerConfiguration {


    /**
     * 对C端用户的接口文档
     *
     * @return
     */
    @Bean
    public Docket webApiDoc() {

        return new Docket(DocumentationType.OAS_30)
                .groupName("用户端接口文档")
                .pathMapping("/")

                //定义是否开启Swagger，false是关闭，可以通过变量去控制，线上关闭
                .enable(true)

                //配置文档的元信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liuhf"))
                //正则匹配请求路径，并分配到当前项目组
                .paths(PathSelectors.ant("/api/**"))
                .build()
                // 新版SwaggerUI3.0
                .globalRequestParameters(globalReqeustParameters())
                .globalResponses(HttpMethod.GET,getGlabalResponseMessage())
                .globalResponses(HttpMethod.POST,getGlabalResponseMessage());


    }


    /**
     * 对管理端的接口文档
     *
     * @return
     */
    @Bean
    public Docket adminApiDoc() {

        return new Docket(DocumentationType.OAS_30)
                .groupName("管理端接口文档")
                .pathMapping("/")

                //定义是否开启Swagger，false是关闭，可以通过变量去控制，线上关闭
                .enable(true)

                //配置文档的元信息
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.liuhf"))
                //正则匹配请求路径，并分配到当前项目组
                .paths(PathSelectors.ant("/admin/**"))
                .build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("1024电商平台")
                .description("微服务接口文档")
                .contact(new Contact("小滴课堂-二当家小D", "https://xdclass.net", "微信 xdclass6"))
                .version("v1.0")
                .build();
    }


    /**
     * 配置全局通用参数
     *
     * @return
     */
    private List<RequestParameter> globalReqeustParameters() {

        List<RequestParameter> parameters = new ArrayList<>();
        parameters.add(new RequestParameterBuilder()
                .name("token")
                .description("登录令牌")
                .in(ParameterType.HEADER)
                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                .required(false)
                .build());

//        parameters.add(new RequestParameterBuilder()
//                .name("token2")
//                .description("登录令牌")
//                .in(ParameterType.HEADER)
//                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
//                .required(false)
//                .build());

        return parameters;

    }


    /**
     * 生成通用的响应信息
     */

    private List<Response> getGlabalResponseMessage() {

        List<Response> list = new ArrayList<>();
        list.add(new ResponseBuilder()
                .code("4xx")
                .description("请求错误，根据code和msg检查")
                .build());

        return list;
    }



}
