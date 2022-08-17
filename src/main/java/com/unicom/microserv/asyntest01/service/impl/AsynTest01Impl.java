package com.unicom.microserv.asyntest01.service.impl;

import com.unicom.microserv.asyntest01.dto.Response;
import com.unicom.microserv.asyntest01.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author ymx
 * @Name AsynTest01Impl
 * @CreateTime 2022/8/16
 * @ProjectName AsynTest01
 * @Description:
 */
@Service
public class AsynTest01Impl implements AccessService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StandardEnvironment standardEnvironment;

    @Autowired
    private CallFutureTask callFutureTask;

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
    private String asyUrl;

    @Override
    public LinkedHashMap asynTest() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(callFutureTask);
        System.out.println("get started");
        new Thread(futureTask).start();
        System.out.println("end of start");
        if (futureTask.get() != null) {
            System.out.println("get the result of futureTask" + futureTask.get().toString());
        } else {
            System.out.println("can not get the result of");
        }
        return (LinkedHashMap) futureTask.get();
    }
}
