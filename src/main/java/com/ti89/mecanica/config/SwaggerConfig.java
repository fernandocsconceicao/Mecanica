package com.ti89.mecanica.config;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@ComponentScan
public class SwaggerConfig {


	  @Bean
	    public Docket productApi() {
	    	String groupName= "produto";
	        return new Docket(DocumentationType.SWAGGER_2)
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.ti89.mecanica.resources"))
	                .paths(PathSelectors.regex("/.*"))
	                
	                .build()
	                .groupName(groupName)
	                .apiInfo(metaInfo());
	    }
    


    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Mecanica_app API REST",
                "API para app mecanica",
                "1.0",
                "Terms of Service",
                new Contact("Ti89", "https://github.com/fernandocsconceicao",
                        "fernando.csconceicao@outlook.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }}