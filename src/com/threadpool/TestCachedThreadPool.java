package com.threadpool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.file.WriteLog;
import com.thread.SaleTickets;

/** 
 * <Description> 
 * 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
 * 那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。
 * 此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。<br> 
 *  
 * @author XXX<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月12日 <br>
 * @since V1.0<br>
 * @see com.threadpool <br>
 */

public class TestCachedThreadPool {
    public static void main(String[] args) {
        //创建一个可缓存的线程池
        ExecutorService pool = Executors.newCachedThreadPool();
        //定义四个售票员
        Thread ticketsSeller1 = new SaleTickets("售票员1");
        Thread ticketsSeller2 = new SaleTickets("售票员2");
        Thread ticketsSeller3 = new SaleTickets("售票员3");
        Thread ticketsSeller4 = new SaleTickets("售票员4");
        

        //开始售票流程
        pool.execute(ticketsSeller1);
        pool.execute(ticketsSeller2);
        pool.execute(ticketsSeller3);
        pool.execute(ticketsSeller4);
        try {
            WriteLog.write("saleTickets.log", "\r\n"+"newCachedThreadPool方式售票结果:"+"\r\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //关闭线程池
        pool.shutdown();
    }
}
