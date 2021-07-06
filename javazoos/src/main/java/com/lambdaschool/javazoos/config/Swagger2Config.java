package com.lambdaschool.javazoos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration // annotation to tell Spring this is a configuration file
@EnableSwagger2 // annotation to enable Swagger
@Import(BeanValidatorPluginsConfiguration.class) // connects our validation constraints to this configuration class
public class Swagger2Config
{
    @Bean
    public Docket api()
    {
        return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors
                .basePackage("com.lambdaschool.javazoos"))
            .paths(PathSelectors.regex("/.*"))
            .build()
            .apiInfo(apiEndPointsInfo());
    }

    private ApiInfo apiEndPointsInfo()
    {
        return new ApiInfoBuilder().title("Java Zoos Project")
            .description("A Project Used to Introduce Swagger Documentation")
            .contact(new Contact("Alden Ho",
                "http://www.lambdaschool.com",
                "haldeno.52@gmail.com"))
            .license("MIT")
            .licenseUrl("https://github.com/LambdaSchool/java-sampleemps/blob/master/LICENSE")
            .version("1.0.0")
            .build();
    }
}