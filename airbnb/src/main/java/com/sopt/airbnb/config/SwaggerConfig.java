package com.sopt.airbnb.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .title("airbnb 게 섯거라")
                .description("NOW SOPT 합동 세미나 웹 2팀 공주님들이 사용하실 API입니다.")
                .version("v1");

        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .info(info);
    }
}
