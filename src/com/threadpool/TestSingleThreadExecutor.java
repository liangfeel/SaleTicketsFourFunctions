package com.threadpool;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.file.WriteLog;
import com.thread.SaleTickets;

/** 
 * <Description>创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。
 *              如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行
 *              顺序按照任务的提交顺序执行。 <br> 
 *  
 * @author zhangliang<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月12日 <br>
 * @since V1.0<br>
 * @see com.threadpool <br>
 */

public class TestSingleThreadExecutor {
    public static void main(String[] args) {
        //创建一个单线程的线程池
        ExecutorService pool = Executors.newSingleThreadExecutor();
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
            WriteLog.write("saleTickets.log", "\r\n"+"newSingleThreadExecutor方式售票结果:"+"\r\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //关闭线程池
        pool.shutdown();
    }
}
