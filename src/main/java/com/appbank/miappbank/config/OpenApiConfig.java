package com.appbank.miappbank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public OpenAPI bankAppOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("App Bank")
                    .description("App bancaria desarrollada en clase con Spring Boot...")
                    .version("1.0.0")
                    .contact(new Contact()
                        .name("David Morón")
                        .email("david.moroncr@amigo.edu.com")
                        .url("https://github.com/DavidMrn/logic_app_bank.git"))
                    .license(new License()
                        .name("MTI License")
                        .url("https://github.com/DavidMrn/logic_app_bank/blob/main/LICENSE")));
    }
}
