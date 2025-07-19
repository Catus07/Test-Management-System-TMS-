package com.report.tms.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    OpenAPI myCustomConfiguration(){
        return new OpenAPI().info(new Info()
                .title("Testing Management System")
                .summary("tms spring platform is a spring boot APIs based for managing Quality assurance and testing software Reports \"")
                .description("Created by: Revocatus Joseph"));
        //http://localhost:8080/swagger-ui/index.html
    }


}
