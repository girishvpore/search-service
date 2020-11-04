package com.girishpore.searchservice.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SearchConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("*").allowCredentials(true);
            }
        };
    }

    @Bean
    public AWSStaticCredentialsProvider awsDynamoCredentialsProviderDevelopment() {
        return new AWSStaticCredentialsProvider(new DefaultAWSCredentialsProviderChain().getCredentials());
    }
}