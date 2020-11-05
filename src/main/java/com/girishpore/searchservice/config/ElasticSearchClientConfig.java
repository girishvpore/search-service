package com.girishpore.searchservice.config;

import com.amazonaws.auth.AWS4Signer;
import com.amazonaws.auth.AWSCredentialsProvider;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Creates RestHighLevelClient to connect to AWS elastic search
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.girishpore.searchservice.dao")
public class ElasticSearchClientConfig extends AbstractElasticsearchConfiguration {

    @Value("${amazon.elasticsearch.url}")
    private String endpoint = null;

    @Value("${amazon.elasticsearch.region}")
    private String region = null;

    @Autowired
    private AWSCredentialsProvider awsCredentialsProvider;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        AWS4Signer aws4Signer = new AWS4Signer();
        String serviceName = "es";
        aws4Signer.setServiceName(serviceName);
        aws4Signer.setRegionName(region);
        HttpRequestInterceptor interceptor = new AWSRequestSigningApacheInterceptor(serviceName, aws4Signer, awsCredentialsProvider);
        return new RestHighLevelClient(RestClient.builder(HttpHost.create(endpoint)).setHttpClientConfigCallback(e -> e.addInterceptorLast(interceptor)));
    }
}