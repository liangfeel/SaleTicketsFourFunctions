package com.threadpool;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.file.WriteLog;
import com.thread.SaleTickets;

/** 
 * <Description> <br> 
 *  
 * @author XXX<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2016年3月14日 <br>
 * @since V1.0<br>
 * @see com.threadpool <br>
 */

public class TestThreadPoolExecutor {

    /**
     * Description: <br> 
     *  
     * @author XXX<br>
     * @taskId <br>
     * @param args <br>
     */
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 6, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
      //定义四个售票员
        Thread ticketsSeller1 = new SaleTickets("售票员1");
        Thread ticketsSeller2 = new SaleTickets("售票员2");
        Thread ticketsSeller3 = new SaleTickets("售票员3");
        Thread ticketsSeller4 = new SaleTickets("售票员4");
        //开始售票流程
        threadPoolExecutor.execute(ticketsSeller1);
        threadPoolExecutor.execute(ticketsSeller2);
        threadPoolExecutor.execute(ticketsSeller3);
        threadPoolExecutor.execute(ticketsSeller4);
        try {
            WriteLog.write("saleTickets.log", "\r\n"+"ThreadPoolExecutor方式售票结果:"+"\r\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        //关闭线程池
        threadPoolExecutor.shutdown();
    }

}
