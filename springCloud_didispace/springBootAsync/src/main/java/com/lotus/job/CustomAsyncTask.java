package com.lotus.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * Created by zhusheng on 2017/9/20 0020.
 */
@Component
public class CustomAsyncTask {
    public static Random random =new Random();

    Log log = LogFactory.getLog(this.getClass());

    @Async("mySimpleAsync")
    public Future<String> doTaskOne() throws Exception{
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<String>("任务一完成");
    }

    @Async("myAsync")
    public Future<String> doTaskTwo() throws Exception{
        log.info("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务二，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<String>("任务二完成");
    }
}
