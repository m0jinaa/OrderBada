package com.farmer.OrderBada.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {

        Info info = new Info()
                .version("v1.0.0")
                .title("OrderBada API")
                .description("판매자와 구매자 모두 편리한 농산물 택배주문");

        return new OpenAPI()
                .info(info);
    }
}