package com.unicom.microserv.asyntest01.service.impl;

import com.unicom.microserv.asyntest01.Asyntest01Application;
import com.unicom.microserv.asyntest01.dto.Response;
import org.springframework.beans.factory.annotation.AnnotationBeanWiringInfoResolver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author ymx
 * @Name CallFutureTask
 * @CreateTime 2022/8/16
 * @ProjectName AsynTest01
 * @Description:
 */
@Service
public class CallFutureTask implements Callable<Object> {


    AtomicInteger atomicInteger = new AtomicInteger();

    private final ReentrantLock lock = new ReentrantLock();

    private static volatile int accumulateNum = 0;

    @Value("${resttemplate.http.send.retryCount}")
    private int retryCount;
    @Value("${resttemplate.http.send.request.timeout}")
    private int requestTimeout;
    @Value("${resttemplate.http.send.connect.timeout}")
    private int connectTimeout;
    @Value("${resttemplate.http.send.socket.timeout}")
    private int socketTimeout;
    @Value("${resttemplate.http.send.max.total}")
    private int maxTotal;
    @Value("${resttemplate.http.send.max.route}")
    private int maxRoute;
    @Value("${resttemplate.http.keepLive.time}")
    private int keepLiveTime;
    @Value("${resttemplate.http.connect.time}")
    private int connectTime;
    @Value("${asyn.port1}")
    private String port1;

    @Override
    public Object call() throws Exception {
        RequestDto requestDto = new RequestDto();
        requestDto.setDate(String.valueOf(new Date()));

        requestDto.setSerialNum(accumulateNum);
        atomicInteger.getAndIncrement();

        RestTemplate restTemplate = Asyntest01Application.ac.getBean(RestTemplate.class);

        HttpEntity<RequestDto> httpEntity = new HttpEntity<>(requestDto,getHttpHeaders());
        ResponseEntity<Object> res = restTemplate.exchange(port1,HttpMethod.POST, httpEntity, Object.class);

        List list = new ArrayList<>();
        Thread.sleep(10000);

        return res.getBody();
    }

    private HttpHeaders getHttpHeaders(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return httpHeaders;
    }
}
