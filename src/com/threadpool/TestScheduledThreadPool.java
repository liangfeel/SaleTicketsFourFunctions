package com.threadpool;

import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.file.WriteLog;
import com.runnable.SaleTicketsRunnable;

/** 
 * <Description> 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。<br> 
 *  
 * @author XXX<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月12日 <br>
 * @since V1.0<br>
 * @see com.threadpool <br>
 */

public class TestScheduledThreadPool {

    /**
     * Description: 创建一个大小无限的线程池。   <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        //创建一个大小无限的线程池。
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(4);
        SaleTicketsRunnable saleTicketsRunnable = new SaleTicketsRunnable();
        exec.scheduleAtFixedRate(saleTicketsRunnable, 1000, 1000, TimeUnit.MILLISECONDS);
        exec.scheduleAtFixedRate(saleTicketsRunnable, 1000, 2000, TimeUnit.MILLISECONDS);
        exec.scheduleAtFixedRate(saleTicketsRunnable, 1000, 2000, TimeUnit.MILLISECONDS);
        exec.scheduleAtFixedRate(saleTicketsRunnable, 1000, 2000, TimeUnit.MILLISECONDS);
        try {
            WriteLog.write("saleTickets.log", "\r\n"+"ScheduledThreadPoolExecutor方式售票结果:"+"\r\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
