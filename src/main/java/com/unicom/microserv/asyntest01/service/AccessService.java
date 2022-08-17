package com.unicom.microserv.asyntest01.service;

import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;

/**
 * @Author ymx
 * @Name AccessService
 * @CreateTime 2022/8/16
 * @ProjectName AsynTest01
 * @Description:
 */

public interface AccessService {
    LinkedHashMap asynTest() throws ExecutionException, InterruptedException;
}
