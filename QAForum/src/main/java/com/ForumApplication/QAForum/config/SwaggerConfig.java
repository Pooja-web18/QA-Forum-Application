package com.ForumApplication.QAForum.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("QA Forum Application")
                        .version("1.0")
                        .description("API Documentation for the QA Forum application"))
                .addServersItem(new Server().url("http://localhost:8080"));
    }
}
