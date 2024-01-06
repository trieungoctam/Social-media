package com.dynamite.facebook.config;

import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {
    @Value("${spring.minio.accessKey}")
    private String accessKey;
    @Value("${spring.minio.secretKey}")
    private String secretKey;
    @Value("${spring.minio.url}")
    private String url;
    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(url)
                .credentials(accessKey, secretKey)
                .build();
    }
}
