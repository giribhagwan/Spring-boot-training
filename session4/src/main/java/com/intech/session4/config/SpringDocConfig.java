package com.intech.session4.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.examples.Example;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@OpenAPIDefinition
public class SpringDocConfig {
    ReadJsonFileToJsonObject readJsonFileToJsonObject=new ReadJsonFileToJsonObject();

    @Bean
    public OpenAPI baseOpenAPI() throws IOException {
        ApiResponse badRequest=new ApiResponse().content(
                new Content().addMediaType("application/json",
                        new MediaType().addExamples("default",
                        new Example().value(readJsonFileToJsonObject.read().get("badRequest").toString())))
                );
        Components components=new Components();
        components.addResponses("badRequest",badRequest);
        return new OpenAPI()
                .components(components)
                .info(new Info().title("My Task management").version("1.0.0").description("My Task management description"));
    }
}
