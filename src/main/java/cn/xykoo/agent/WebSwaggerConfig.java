package cn.xykoo.agent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author J.Tang
 */
@Configuration
@EnableSwagger2
public class WebSwaggerConfig {

    @Bean
    public Docket testApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                // base，最终调用接口后会和paths拼接在一起
                .pathMapping("/")
                .select()
                .apis(RequestHandlerSelectors.basePackage("cn.xykoo.agent.controller"))
                .build()
                .globalOperationParameters(setHeaderToken());
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("衣库API")
                .description("衣库接口测试文档")
                .version("1.0")
                .build();
    }
    private List<Parameter> setHeaderToken() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("token")
                .description("token")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false).build();
        pars.add(tokenPar.build());
        return pars;
    }
}
