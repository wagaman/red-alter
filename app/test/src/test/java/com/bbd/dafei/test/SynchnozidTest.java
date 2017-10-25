package com.bbd.dafei.test;

/**
 * @author Ian.Su
 * @version $Id: SynchnozidTest.java, v 0.1 2017/6/6 11:25 Ian.Su Exp $
 */
public class SynchnozidTest {


    public static void main(String [] agrs){

        class Tt implements Runnable{
            String b = null;
            public Tt(String c){
                b=c;
            }
            public void run(){

                synchronized (new String(b).intern()){
                    long now = System.currentTimeMillis();
                    for(int k=0;k<9999999999999l;k++){
                        System.err.println(now);
                    }

                }

            }
        }

        new Thread(new Tt("1")).start();
        new Thread(new Tt("1")).start();


    }

}
