package com.girishpore.searchservice.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration for AWS provide
 */
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

    /**
     * Uses AWSCredentialsProviderChain to find the credentials
     * @see <a href="https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/credentials.html"</a>
     */
    @Bean
    public AWSStaticCredentialsProvider awsDynamoCredentialsProviderDevelopment() {
        return new AWSStaticCredentialsProvider(new DefaultAWSCredentialsProviderChain().getCredentials());
    }
}