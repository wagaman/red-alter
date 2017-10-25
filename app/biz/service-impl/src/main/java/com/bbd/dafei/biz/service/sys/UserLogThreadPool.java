package com.bbd.dafei.biz.service.sys;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 记录日志线程池
 * Created by wish on 2017/6/6.
 */
public class UserLogThreadPool {
    /**
     * 默认创建2个线程
     */
    private static ExecutorService userLogThreadPool = Executors.newFixedThreadPool(2);

    private UserLogThreadPool() {

    }


    /**
     * 执行线程
     */
    public static void execute(Runnable thread) {
        userLogThreadPool.execute(thread);
    }
}
