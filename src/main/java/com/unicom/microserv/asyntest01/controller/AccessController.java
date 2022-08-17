package com.unicom.microserv.asyntest01.controller;

import com.unicom.microserv.asyntest01.Asyntest01Application;
import com.unicom.microserv.asyntest01.dto.Response;
import com.unicom.microserv.asyntest01.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

/**
 * @Author ymx
 * @Name AccessController
 * @CreateTime 2022/8/16
 * @ProjectName AsynTest01
 * @Description:
 */

@RestController
@RequestMapping("/asyntest01/access")
public class AccessController {

    @Autowired
    private AccessService accessService;

    @RequestMapping("/asyn")
    public Response testAsyn() {
        try {
            LinkedHashMap linkedHashMap = accessService.asynTest();
            return Response.success(linkedHashMap);
        } catch(Exception e) {
            return Response.fail(e.toString());
        }
    }
}
