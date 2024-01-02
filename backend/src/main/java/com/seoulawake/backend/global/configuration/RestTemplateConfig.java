package com.seoulawake.backend.global.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class RestTemplateConfig {
    private final RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate kakaoTemplate() {
        return restTemplateBuilder.rootUri("http://localhost:8080")
                .additionalInterceptors(new RestTemplateHttpRequestInterceptor())
                .setConnectTimeout(Duration.ofMillis(300))
                .build();
    }
}
