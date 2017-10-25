package com.bbd.dafei.biz.service.sys;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 系统线程池
 * @author Ian.Su
 * @version $Id: SystemThreadPool.java, v 0.1 2017/4/14 18:21 Ian.Su Exp $
 */
public class SystemThreadPool {


    /**
     * 默认创建50个线程
     * */
    private static ExecutorService sysThreadPool = Executors.newFixedThreadPool(50);

    private SystemThreadPool(){

    }


    /**
     * 执行线程
     * */
    public static void execute(Runnable thread){
        sysThreadPool.execute(thread);
    }



}
