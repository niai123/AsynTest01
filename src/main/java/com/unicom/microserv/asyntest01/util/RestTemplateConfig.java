package com.unicom.microserv.asyntest01.util;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @Author ymx
 * @Name RestTemplate
 * @CreateTime 2022/8/16
 * @ProjectName AsynTest01
 * @Description:
 */

@Component
@Configuration
public class RestTemplateConfig {

    @Bean
    @Scope("prototype")
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new org.springframework.web.client.RestTemplate();
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
}
