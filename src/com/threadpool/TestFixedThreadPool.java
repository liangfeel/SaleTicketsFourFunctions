package com.threadpool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.file.WriteLog;
import com.thread.SaleTickets;

/** 
 * <Description>
 * 创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
 * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
 *  <br> 
 *  
 * @author XXX<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月12日 <br>
 * @since V1.0<br>
 * @see com.threadpool <br>
 */

public class TestFixedThreadPool {

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        //创建一个可重用的固定线程的线程池
        ExecutorService pool = Executors.newFixedThreadPool(4);
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
            WriteLog.write("saleTickets.log", "\r\n"+"newFixedThreadPool方式售票结果:"+"\r\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //关闭线程池
        pool.shutdown();
    }

}
