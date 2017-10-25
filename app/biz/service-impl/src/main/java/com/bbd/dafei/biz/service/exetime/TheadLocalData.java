package com.bbd.dafei.biz.service.exetime;

import java.util.LinkedList;

/**
 *
 * 记录当前线程的一些数据
 * @author Ian.Su
 * @version $Id: TheadLocalData.java, v 0.1 2017/3/9 10:04 Ian.Su Exp $
 */
public class TheadLocalData {


    /**
     * 记录方法执行时间
     * */
    private static ThreadLocal<LinkedList<String>> costTimeList = new ThreadLocal<LinkedList<String>>(){
        @Override
        protected LinkedList<String> initialValue() {
            return new LinkedList<String>();
        }
    };

    public static void addCostTime(String costTime){
        costTimeList.get().add(costTime);
    }


    public static LinkedList<String> getCostTimeAndClean(){
        LinkedList<String> list = costTimeList.get();
        costTimeList.remove();
        return list;
    }
}
